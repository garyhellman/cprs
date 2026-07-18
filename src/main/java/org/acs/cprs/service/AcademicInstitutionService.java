package org.acs.cprs.service;

import java.util.ArrayList;
import java.util.List;

import org.acs.cprs.model.AcademicInstitution;
import org.acs.cprs.repository.AcademicInstitutionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcademicInstitutionService {

    private final AcademicInstitutionRepository academicInstitutionRepository;

    public AcademicInstitutionService(AcademicInstitutionRepository academicInstitutionRepository) {
        this.academicInstitutionRepository = academicInstitutionRepository;
    }

    @Transactional(readOnly = true)
    public List<AcademicInstitution> getAcademicInstitutionList(int start, int limit) {
        int page = limit > 0 ? start / limit : 0;
        return academicInstitutionRepository.findAll(PageRequest.of(page, Math.max(limit, 1))).getContent();
    }

    @Transactional
    public List<AcademicInstitution> create(AcademicInstitution academicInstitution) {
        List<AcademicInstitution> created = new ArrayList<>();
        created.add(academicInstitutionRepository.save(academicInstitution));
        return created;
    }

    @Transactional
    public List<AcademicInstitution> update(AcademicInstitution academicInstitution) {
        List<AcademicInstitution> updated = new ArrayList<>();
        updated.add(academicInstitutionRepository.save(academicInstitution));
        return updated;
    }

    @Transactional
    public void delete(AcademicInstitution academicInstitution) {
        academicInstitutionRepository.deleteById(academicInstitution.getId());
    }

    @Transactional(readOnly = true)
    public long getTotalAcademicInstitutions() {
        return academicInstitutionRepository.count();
    }
}
