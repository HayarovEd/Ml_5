package com.dengi.v.dolg.perkon.domain.model

sealed interface TypeCard{
    object CardCredit: TypeCard
    object CardDebit: TypeCard
    object CardInstallment: TypeCard
}