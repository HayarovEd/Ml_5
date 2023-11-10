package com.dengi.v.dolg.perkon.domain.model.basedto

import com.dengi.v.dolg.perkon.domain.model.TypeCard

sealed class BaseState{
    object Loans: BaseState()
    class Cards(val typeCard: TypeCard): BaseState()
    object Credits: BaseState()
}
