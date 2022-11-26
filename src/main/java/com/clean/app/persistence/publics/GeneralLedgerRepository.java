//GeneralLedger
package com.clean.app.persistence.publics;

import com.clean.app.entity.publics.GeneralLedger;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@JaversSpringDataAuditable
public interface GeneralLedgerRepository extends JpaRepository<GeneralLedger, Long>, JpaSpecificationExecutor<GeneralLedger> {
    Optional<GeneralLedger> findByFiscalYearIdAndCodingBlockIdAndSubLedgerTypeId(Long fiscalYear, Long codingBlock, Long subLedgerTypeId);
}
