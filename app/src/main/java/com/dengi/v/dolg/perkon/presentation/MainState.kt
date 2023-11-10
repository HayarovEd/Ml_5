package com.dengi.v.dolg.perkon.presentation

import com.dengi.v.dolg.perkon.domain.model.StatusApplication
import com.dengi.v.dolg.perkon.domain.model.basedto.BaseDto
import com.dengi.v.dolg.perkon.domain.model.basedto.CardsCredit
import com.dengi.v.dolg.perkon.domain.model.basedto.CardsDebit
import com.dengi.v.dolg.perkon.domain.model.basedto.CardsInstallment


data class MainState(
    val instanceIdMyTracker: String? = null,
    val fireBaseToken: String? = null,
    val gaid: String? = null,
    val message: String = "",
    val affsub1Unswer: String = "",
    val affsub2Unswer: String = "",
    val affsub2UnswerAF: String = "",
    val affsub2UnswerMT: String = "",
    val affsub2UnswerEmpty: String = "",
    val affsub3Unswer: String = "",
    val affsub5Unswer: String = "",
    val dbData: BaseDto? = null,
    val statusApplication: StatusApplication = StatusApplication.Loading/*Web(url = "https://ya.ru/", offerName = "Offer")*/,
    val creditCards: List<CardsCredit> = emptyList(),
    val debitCards: List<CardsDebit> = emptyList(),
    val installmentCards: List<CardsInstallment> = emptyList(),
)
