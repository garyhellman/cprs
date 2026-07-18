package org.acs.cprs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acs.cprs.model.AcademicInstitution;
import org.acs.cprs.model.AcademicInstitutionWrapper;
import org.acs.cprs.service.AcademicInstitutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcademicInstitutionController {

    private static final Logger logger = LoggerFactory.getLogger(AcademicInstitutionController.class);

    private final AcademicInstitutionService academicInstitutionService;

    public AcademicInstitutionController(AcademicInstitutionService academicInstitutionService) {
        this.academicInstitutionService = academicInstitutionService;
    }

    @RequestMapping("/acadinstitution/view.action")
    public Map<String, ?> view(@RequestParam int start, @RequestParam int limit) {
        logger.debug("AcademicInstitutionController: view");
        try {
            List<AcademicInstitution> institutions = academicInstitutionService.getAcademicInstitutionList(start, limit);
            long total = academicInstitutionService.getTotalAcademicInstitutions();
            return AcademicInstitution.mapOK(institutions, total);
        } catch (Exception e) {
            logger.error("Failed to load academic institutions", e);
            return AcademicInstitution.mapError("Error retrieving AcademicInstitutions from database.");
        }
    }

    @PostMapping("/acadinstitution/create.action")
    public Map<String, ?> create(@RequestBody AcademicInstitutionWrapper data) {
        try {
            List<AcademicInstitution> institutions = academicInstitutionService.create(data.getData());
            return AcademicInstitution.mapOK(institutions);
        } catch (Exception e) {
            logger.error("Failed to create academic institution", e);
            return AcademicInstitution.mapError("Error trying to create academicInstitution.");
        }
    }

    @PostMapping("/acadinstitution/update.action")
    public Map<String, ?> update(@RequestBody AcademicInstitutionWrapper data) {
        try {
            List<AcademicInstitution> institutions = academicInstitutionService.update(data.getData());
            return AcademicInstitution.mapOK(institutions);
        } catch (Exception e) {
            logger.error("Failed to update academic institution", e);
            return AcademicInstitution.mapError("Error trying to update academicInstitution.");
        }
    }

    @PostMapping("/acadinstitution/delete.action")
    public Map<String, ?> delete(@RequestBody AcademicInstitutionWrapper data) {
        try {
            academicInstitutionService.delete(data.getData());
            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("success", true);
            return modelMap;
        } catch (Exception e) {
            logger.error("Failed to delete academic institution", e);
            return AcademicInstitution.mapError("Error trying to delete academicInstitution.");
        }
    }
}
