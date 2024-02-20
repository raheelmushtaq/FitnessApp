package com.zert.fitness.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.zert.fitness.R
import com.zert.fitness.utils.PaddingsConst

@Composable
fun AppHeader(
    modifier: Modifier = Modifier,
    titleModifier: Modifier = Modifier,
    navHostController: DestinationsNavigator,
    showBackButton: Boolean = false,
    showRightMenuButton: Boolean = false,
    title: String = "",
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.blue)),
    ) {
        Row(
            modifier = modifier
                .padding(PaddingsConst.appPadding)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (showBackButton) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    modifier = Modifier
                        .width(PaddingsConst.toolbarBackIconWidth)
                        .height(PaddingsConst.toolbarBackIconHeight)
                        .rotate(180f)
                        .padding(3.dp)
                        .clickable {
                            navHostController.navigateUp()
                        },
                    contentDescription = stringResource(
                        id = R.string.back
                    ),
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.white))
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
            Text(
                text = title,
                modifier = titleModifier.weight(1f),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white)
            )
            if (showRightMenuButton) {
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_more_button),
                    modifier = Modifier
                        .width(PaddingsConst.toolbarBackIconWidth)
                        .height(PaddingsConst.toolbarBackIconHeight)
                        .clickable {
                            navHostController.navigateUp()
                        },
                    contentDescription = stringResource(
                        id = R.string.back
                    ),
                )
            }

        }
    }
}

@Preview
@Composable

fun HeaderPreview() {
//    AppHeader(
//        navHostController = remem,
//        title = stringResource(id = R.string.app_name),
//        showBackButton = false
//    )
}