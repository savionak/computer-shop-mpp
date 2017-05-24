package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.DocumentController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.wrapper.DocumentGeneratorCallWrapper;
import by.bsuir.mpp.computershop.document.DocumentType;
import by.bsuir.mpp.computershop.document.generator.DocumentGenerator;
import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.document.model.provider.impl.*;
import by.bsuir.mpp.computershop.entity.*;
import by.bsuir.mpp.computershop.service.ComponentStoreService;
import by.bsuir.mpp.computershop.service.CustomerService;
import by.bsuir.mpp.computershop.service.ProviderService;
import by.bsuir.mpp.computershop.service.UserAuthService;
import by.bsuir.mpp.computershop.utils.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

public class DocumentControllerImpl implements DocumentController {

    private static final Logger logger = Logger.getLogger(DocumentControllerImpl.class);
    private ComponentStoreService storeService;
    private ProviderService providerService;
    private UserAuthService userAuthService;
    private CustomerService customerService;

    @Autowired
    public DocumentControllerImpl(ComponentStoreService storeService,
                                  ProviderService providerService,
                                  UserAuthService userAuthService,
                                  CustomerService customerService) {
        this.storeService = storeService;
        this.providerService = providerService;
        this.userAuthService = userAuthService;
        this.customerService = customerService;
    }

    private static String sanitizeFilename(String filename) {
        return filename.replaceAll("[^a-zA-Z0-9.-]", "_");
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

    @Override
    public void exportProviderImports(
            @PathVariable Long id,
            @RequestParam("type") DocumentType documentType,
            HttpServletResponse response) throws ControllerException {
        Provider provider = wrapServiceCall(() -> providerService.getOne(id), logger);

        List<Import> imports = provider.getImports();

        dispatchDocumentRequest(
                response,
                documentType,
                provider,
                imports,
                new ProviderImportsProvider());
    }

    @Override
    public void exportProviders(@RequestParam("type") DocumentType documentType,
                                HttpServletResponse response) throws ControllerException {
        Iterable<Provider> providersIterable = wrapServiceCall(() -> providerService.getAll(), logger);

        List<Provider> providers = Util.toList(providersIterable);

        dispatchDocumentRequest(
                response,
                documentType,
                null,
                providers,
                new ProvidersProvider());
    }

    @Override
    public void exportUsers(@RequestParam("type") DocumentType documentType,
                            HttpServletResponse response) throws ControllerException {
        Iterable<UserAuth> usersIterable = wrapServiceCall(() -> userAuthService.getAll(), logger);

        List<UserAuth> users = Util.toList(usersIterable);

        dispatchDocumentRequest(
                response,
                documentType,
                null,
                users,
                new UsersProvider());
    }

    @Override
    public void exportCustomers(@RequestParam("type") DocumentType documentType,
                                HttpServletResponse response) throws ControllerException {
        Iterable<Customer> customersIterable = wrapServiceCall(() -> customerService.getAll(), logger);

        List<Customer> customer = Util.toList(customersIterable);

        dispatchDocumentRequest(
                response,
                documentType,
                null,
                customer,
                new CustomersProvider());
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String now = dateFormat.format(new Date());

        String filename = String.format("%s-%s.%s",
                contentProvider.createFilename(mainEntity),
                now,
                documentGenerator.getFileExtension());
        filename = sanitizeFilename(filename);
        return filename;
    }
}
