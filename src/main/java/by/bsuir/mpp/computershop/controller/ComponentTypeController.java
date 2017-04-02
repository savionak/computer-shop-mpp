package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/componentType")
public class ComponentTypeController {

    private final ComponentTypeService componentTypeService;

    @Autowired
    public ComponentTypeController(ComponentTypeService componentTypeService) {
        this.componentTypeService = componentTypeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ComponentType> getAllComponentTypes() {
        return componentTypeService.getAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ComponentType getComponentTypeById(@PathVariable("id") Long id) {
        return componentTypeService.getOne(id);
    }

    @RequestMapping(path = "add", method = RequestMethod.POST)
    public ComponentType addComponentType(@RequestBody ComponentType newType) {
        return componentTypeService.add(newType);
    }

    @RequestMapping(path = "update/{id}", method = RequestMethod.PUT)
    public ComponentType updateComponentType(@PathVariable Long id, @RequestBody ComponentType type) {
        return componentTypeService.update(id, type);
    }

    @RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteComponentTypeById(@PathVariable("id") Long id) {
        componentTypeService.delete(id);
    }

}
