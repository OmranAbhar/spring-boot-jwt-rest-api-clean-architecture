package com.clean.app.entity.publics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "general_ledger", schema = "public")
public class GeneralLedger implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "fiscal_year_id")
    private Long fiscalYearId;

    @Basic
    @Column(name = "coding_block_id")
    private Long codingBlockId;

    @Basic
    @Column(name = "currency_id")
    private Long currencyId;

    @Basic
    @Column(name = "opening_balance_debit_dc")
    private BigDecimal openingBalanceDebitDc;

    @Basic
    @Column(name = "opening_balance_credit_dc")
    private BigDecimal openingBalanceCreditDc;

    @Basic
    @Column(name = "opening_balance_debit_fc")
    private BigDecimal openingBalanceDebitFc;

    @Basic
    @Column(name = "opening_balance_credit_fc")
    private BigDecimal openingBalanceCreditFc;

    @Basic
    @Column(name = "actual_ytd_debit_dc")
    private BigDecimal actualYtdDebitDc;

    @Basic
    @Column(name = "actual_ytd_credit_dc")
    private BigDecimal actualYtdCreditDc;

    @Basic
    @Column(name = "actual_ytd_debit_fc")
    private BigDecimal actualYtdDebitFc;

    @Basic
    @Column(name = "actual_ytd_credit_fc")
    private BigDecimal actualYtdCreditFc;

    @Basic
    @Column(name = "sub_ledger_type_id")
    private Long subLedgerTypeId;

    @Basic
    @Column(name = "origin_enum")
    private String originEnum;

    @Basic
    @Column(name = "institution_id")
    private Long institutionId;

    @Basic
    @Column(name = "reference_domain_id")
    private Long referenceDomainId;

}