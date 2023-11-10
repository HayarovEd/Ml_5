package com.dengi.v.dolg.perkon.presentation

import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.dengi.v.dolg.perkon.domain.model.StatusApplication
import com.dengi.v.dolg.perkon.domain.model.TypeCard
import com.dengi.v.dolg.perkon.domain.model.basedto.BaseState
import org.zaim.na.kartu.polus.presentation.ConnectScreen
import org.zaim.na.kartu.polus.presentation.LoadingScreen
import org.zaim.na.kartu.polus.presentation.OfferScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Sample(
    viewModel: MainViewModel = hiltViewModel(),
) {

    val state = viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent
    val context = LocalContext.current

    val launcherMultiplePermissions = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->
        val areGranted = permissionsMap.values.reduce { acc, next -> acc && next }
        if (areGranted) {
           Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
        } else {
            //Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }
    val loanLazyState = rememberLazyListState()
    val creditLazyState = rememberLazyListState()
    val creditCardloanLazyState = rememberLazyListState()
    val debitCardLazyState = rememberLazyListState()
    val instalmentCardLazyState = rememberLazyListState()
    val typeCard = if (!state.value.creditCards.isNullOrEmpty()) TypeCard.CardCredit
    else if (!state.value.debitCards.isNullOrEmpty()) TypeCard.CardDebit else TypeCard.CardInstallment
    when (val currentState = state.value.statusApplication) {
        is StatusApplication.Connect -> {
            ConnectScreen(
                baseState = currentState.baseState,
                db = state.value.dbData!!,
                onClickCards = { onEvent(
                    MainEvent.OnChangeBaseState(
                        BaseState.Cards(
                    typeCard = typeCard
                ))
                ) },
                onClickCredits = { onEvent(MainEvent.OnChangeBaseState(BaseState.Credits)) },
                onClickLoans = { onEvent(MainEvent.OnChangeBaseState(BaseState.Loans)) },
                onClickRules = {
                    onEvent(
                        MainEvent.OnChangeStatusApplication(
                            StatusApplication.Info(
                                currentBaseState = currentState.baseState,
                                content = state.value.dbData!!.appConfig.privacyPolicyHtml
                            )
                        )
                    )
                },
                loanLazyState = loanLazyState,
                creditLazyState = creditLazyState,
                creditCardloanLazyState = creditCardloanLazyState,
                debitCardLazyState = debitCardLazyState,
                instalmentCardLazyState = instalmentCardLazyState,
                creditCards = state.value.creditCards,
                debitCards = state.value.debitCards,
                installmentCards = state.value.installmentCards,
                onEvent = viewModel::onEvent
            )
        }

        StatusApplication.Loading -> {
            LoadingScreen()
        }

        is StatusApplication.Mock -> {
            NoInternetScreen(onEvent = viewModel::onEvent)
        }

        is StatusApplication.Info -> {
        }

        is StatusApplication.Offer -> {
            OfferScreen(
                elementOffer = (state.value.statusApplication as StatusApplication.Offer).elementOffer,
                baseState = (state.value.statusApplication as StatusApplication.Offer).currentBaseState,
                onEvent = viewModel::onEvent,
            )
        }

        is StatusApplication.Web -> {
            WebViewScreen(
                url = currentState.url,
                offerName = currentState.offerName,
                onEvent = viewModel::onEvent,
            )
        }

        StatusApplication.NoConnect -> {
            NoInternetScreen(onEvent = viewModel::onEvent)
        }
    }

}