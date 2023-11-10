
package com.dengi.v.dolg.perkon.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dengi.v.dolg.perkon.R
import com.dengi.v.dolg.perkon.data.VALUE_ONE
import com.dengi.v.dolg.perkon.domain.model.ElementOffer
import com.dengi.v.dolg.perkon.domain.model.StatusApplication
import com.dengi.v.dolg.perkon.domain.model.basedto.BaseState
import com.dengi.v.dolg.perkon.domain.model.basedto.Loan
import com.dengi.v.dolg.perkon.ui.theme.baseBackground
import com.dengi.v.dolg.perkon.ui.theme.grey
import com.dengi.v.dolg.perkon.ui.theme.secondText

@Composable
fun ItemLoan(
    modifier: Modifier = Modifier,
    loan: Loan,
    onEvent: (MainEvent) -> Unit,
    baseState: BaseState,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = grey, shape = RoundedCornerShape(10.dp))
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = baseBackground)
            .padding(16.dp)
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onEvent(
                        MainEvent.OnChangeStatusApplication(
                            StatusApplication.Offer(
                                currentBaseState = baseState,
                                ElementOffer(
                                    nameButton = loan.orderButtonText,
                                    name = loan.name,
                                    pathImage = loan.screen,
                                    rang = loan.score,
                                    description = loan.description,
                                    amount = loan.summPrefix + " " + loan.summMin + " " + loan.summMid + " " + loan.summMax + " " + loan.summPostfix,
                                    bet = loan.percentPrefix + " " + loan.percent + " " + loan.percentPostfix,
                                    term = loan.termPrefix + " " + loan.termMin + " " + loan.termMid + " " + loan.termMax + " " + loan.termPostfix,
                                    showMir = loan.showMir,
                                    showVisa = loan.showVisa,
                                    showMaster = loan.showMastercard,
                                    showQiwi = loan.showQiwi,
                                    showYandex = loan.showYandex,
                                    showCache = loan.showCash,
                                    showPercent = loan.hidePercentFields,
                                    showTerm = loan.hideTermFields,
                                    order = loan.order
                                )
                            )
                        )
                    )
                },
            model = loan.screen,
            contentScale = ContentScale.FillWidth,
            contentDescription = ""
        )
        Spacer(modifier = modifier.height(13.dp))
        Text(
            color = secondText,
            fontStyle = FontStyle(R.font.roboto),
            fontSize = 20.sp,
            fontWeight = FontWeight(600),
            text = loan.name
        )
        /*Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                color = black,
                fontStyle = FontStyle(R.font.soyuz_grotesk_bold),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                text = loan.name
            )
            Rang(
                rang = loan.score
            )
        }*/
        Spacer(modifier = modifier.height(13.dp))
        RowData(
            title = stringResource(id = R.string.amount),
            content = loan.summPrefix +" " + loan.summMin +" " + loan.summMid +" " + loan.summMax +" " + loan.summPostfix
        )
        if (loan.hidePercentFields == VALUE_ONE) {
            Spacer(modifier = modifier.height(8.dp))
            RowData(
                title = stringResource(id = R.string.bet),
                content = loan.percentPrefix +" " + loan.percent +" " + loan.percentPostfix
            )
        }
        if (loan.hideTermFields == VALUE_ONE) {
            Spacer(modifier = modifier.height(8.dp))
            RowData(
                title = stringResource(id = R.string.term),
                content = loan.termPrefix +" "+ loan.termMin +" " + loan.termMid +" " + loan.termMax +" " + loan.termPostfix
            )
        }
        Spacer(modifier = modifier.height(13.dp))
        RowCard(
            showVisa = loan.showVisa,
            showMaster = loan.showMastercard,
            showYandex = loan.showYandex,
            showMir = loan.showMir,
            showQivi = loan.showQiwi,
            showCache = loan.showCash
        )
        Spacer(modifier = modifier.height(13.dp))
        RowButtons(
            titleOffer = loan.orderButtonText,
            onEvent = onEvent,
            currentBaseState = baseState,
            name = loan.name,
            pathImage = loan.screen,
            rang = loan.score,
            description = loan.description,
            amount = loan.summPrefix +" " + loan.summMin +" " + loan.summMid +" " + loan.summMax +" " + loan.summPostfix,
            bet  = loan.percentPrefix +" " + loan.percent +" " + loan.percentPostfix,
            term = loan.termPrefix +" "+ loan.termMin +" " + loan.termMid +" " + loan.termMax +" " + loan.termPostfix,
            showMir = loan.showMir,
            showVisa = loan.showVisa,
            showMaster = loan.showMastercard,
            showQiwi = loan.showQiwi,
            showYandex = loan.showYandex,
            showCache = loan.showCash,
            showPercent = loan.hidePercentFields,
            showTerm = loan.hideTermFields,
            order = loan.order,
        )
    }
}
