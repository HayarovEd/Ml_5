package com.dengi.v.dolg.perkon.presentation

import com.dengi.v.dolg.perkon.domain.model.StatusApplication
import com.dengi.v.dolg.perkon.domain.model.TypeCard
import com.dengi.v.dolg.perkon.domain.model.basedto.BaseState


sealed class MainEvent {
    object Reconnect: MainEvent()

    class OnChangeStatusApplication(val statusApplication: StatusApplication): MainEvent()
    class OnChangeBaseState(val baseState: BaseState): MainEvent()
    class OnChangeTypeCard(val typeCard: TypeCard): MainEvent()

    class OnGoToWeb(
        val urlOffer: String,
        val nameOffer: String
        ): MainEvent()
}
