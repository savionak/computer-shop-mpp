package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.DocumentController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.wrapper.DocumentGeneratorCallWrapper;
import by.bsuir.mpp.computershop.document.DocumentType;
import by.bsuir.mpp.computershop.document.generator.DocumentGenerator;
import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.document.model.provider.impl.ComponentStoreProvider;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.service.*;
import by.bsuir.mpp.computershop.utils.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

public class DocumentControllerImpl implements DocumentController {

    private static final Logger logger = Logger.getLogger(DocumentControllerImpl.class);
    private ComponentStoreService storeService;
    private ImportService importService;
    private OrderService orderService;
    private UserAuthService userAuthService;
    private CustomerService customerService;

    @Autowired
    public DocumentControllerImpl(ComponentStoreService storeService,
                                  ImportService importService,
                                  OrderService orderService,
                                  UserAuthService userAuthService,
                                  CustomerService customerService) {
        this.storeService = storeService;
        this.importService = importService;
        this.orderService = orderService;
        this.userAuthService = userAuthService;
        this.customerService = customerService;
    }

    @Override
    public void exportComponentStore(@RequestParam("type") DocumentType documentType,
                                     HttpServletResponse response) throws ControllerException {
        Iterable<ComponentStore> storeIterable = wrapServiceCall(() -> storeService.getCurrentState(), logger);

        List<ComponentStore> store = Util.toList(storeIterable);

        dispatchDocumentRequest(
                response,
                documentType,
                null,
                store,
                new ComponentStoreProvider());
    }

    private <TMainEntity, TTableEntity> void dispatchDocumentRequest(HttpServletResponse response,
                                                                     DocumentType documentType,
                                                                     TMainEntity mainEntity,
                                                                     Collection<TTableEntity> tableEntities,
                                                                     ContentProvider<TMainEntity, TTableEntity> contentProvider) throws ControllerException {
        DocumentGenerator<TMainEntity, TTableEntity> documentGenerator = documentType.createGenerator(contentProvider);
        response.setContentType(documentGenerator.getContentType());
        if (documentGenerator.isForceAttachment()) {
            response.setHeader("Content-disposition", "attachment;filename=" + createFilename(mainEntity, contentProvider, documentGenerator));
        }
        DocumentGeneratorCallWrapper.wrapDocumentGeneratorCall(() -> documentGenerator.writeDocument(
                response,
                mainEntity,
                tableEntities));
    }

    private <TMainEntity, TTableEntity> String createFilename(TMainEntity mainEntity,
                                                              ContentProvider<TMainEntity, TTableEntity> contentProvider,
                                                              DocumentGenerator<TMainEntity, TTableEntity> documentGenerator) {
        String filename = String.format("%s.%s",
                contentProvider.createFilename(mainEntity),
                documentGenerator.getFileExtension());
        filename = sanitizeFilename(filename);
        return filename;
    }

    private static String sanitizeFilename(String filename) {
        return filename.replaceAll("[^a-zA-Z0-9.-]", "_");
    }
}
