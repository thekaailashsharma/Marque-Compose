package quiz.genai.com

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import quiz.genai.com.ui.theme.backGround
import quiz.genai.com.ui.theme.indigo
import quiz.genai.com.ui.theme.monte
import quiz.genai.com.ui.theme.monteEB
import quiz.genai.com.ui.theme.textColor
import quiz.genai.com.ui.theme.yellow
import kotlin.random.Random

data class Company(
    val name: String,
    val logo: Int,
)

val dummyCompanies = listOf(
    Company(
        name = "Google",
        logo = R.drawable.google
    ),
    Company(
        name = "Microsoft",
        logo = R.drawable.microsoft
    ),
    Company(
        name = "Tesla",
        logo = R.drawable.tesla
    ),
    Company(
        name = "Motorola",
        logo = R.drawable.motorola
    ),
    Company(
        name = "Slack",
        logo = R.drawable.slack
    ),
    Company(
        name = "Youtube",
        logo = R.drawable.youtube
    ),
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun JobsBoardingScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backGround)
            .padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        val screenWidth = LocalConfiguration.current.screenWidthDp
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(backGround)
                .drawWithCache {
                    val gradient =
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                backGround.copy(
                                    0.5f
                                )
                            ),
                            startY = size.height / 8.5f,
                            endY = size.height
                        )
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            gradient,
                            blendMode = BlendMode.Multiply
                        )
                    }
                },
        ) {
            itemsIndexed(dummyCompanies) { index, _ ->
                Row(modifier = Modifier.basicMarquee()) {
                    repeat(30) {
                        MarqueeCard(
                        )
                    }
                }
            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Icon(
                    painter = painterResource(id = R.drawable.portal),
                    contentDescription = null,
                    modifier = Modifier
                        .size(350.dp),
                    tint = Color.Unspecified

                )
                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier
                        .padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.size(25.dp))
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = androidx.compose.ui.text.SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = textColor,
                                        fontSize = 35.sp,
                                        fontFamily = monte
                                    )
                                ) {
                                    append("Your ")
                                }
                                withStyle(
                                    style = androidx.compose.ui.text.SpanStyle(
                                        fontWeight = FontWeight.ExtraBold,
                                        color = textColor,
                                        fontSize = 35.sp,
                                        fontFamily = monteEB
                                    )
                                ) {
                                    append("search ")
                                }
                                withStyle(
                                    style = androidx.compose.ui.text.SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = textColor,
                                        fontSize = 35.sp,
                                        fontFamily = monte
                                    )
                                ) {
                                    append("for the next ")
                                }
                                withStyle(
                                    style = androidx.compose.ui.text.SpanStyle(
                                        fontWeight = FontWeight.ExtraBold,
                                        color = indigo.copy(0.8f),
                                        fontSize = 35.sp,
                                        fontFamily = monteEB,
                                        textDecoration = TextDecoration.Underline
                                    )
                                ) {
                                    append("dream ")
                                }
                                withStyle(
                                    style = androidx.compose.ui.text.SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = textColor,
                                        fontSize = 35.sp,
                                        fontFamily = monte
                                    )
                                ) {
                                    append("job is ")
                                }
                                withStyle(
                                    style = androidx.compose.ui.text.SpanStyle(
                                        fontWeight = FontWeight.ExtraBold,
                                        color = yellow,
                                        fontSize = 35.sp,
                                        fontFamily = monteEB
                                    )
                                ) {
                                    append("over !!")
                                }

                            },
                            softWrap = true,
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .padding(horizontal = 10.dp),
                            lineHeight = 50.sp,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.size(25.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White
                            ),
                            border = BorderStroke(1.dp, yellow.copy(alpha = 0.7f)),
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text(
                                    text = "Find your next job",
                                    fontSize = 19.sp,
                                    fontFamily = monteEB,
                                    fontWeight = FontWeight.ExtraBold,
                                    softWrap = true,
                                    modifier = Modifier.fillMaxWidth(0.75f),
                                    textAlign = TextAlign.Center,
                                    color = textColor.copy(0.85f),
                                )
                            }
                        }
                        Spacer(modifier = Modifier.size(25.dp))
                        Text(
                            text = "Know your worth",
                            fontSize = 12.sp,
                            fontFamily = monte,
                            color = textColor.copy(0.55f)
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun MarqueeCard(modifier: Modifier = Modifier) {
    val company = remember {
        mutableStateOf(dummyCompanies[Random.nextInt(0, dummyCompanies.size - 1)])
    }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
        modifier = modifier
            .width(200.dp)
            .height(80.dp)
            .padding(horizontal = 10.dp, vertical = 8.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xFF222324).copy(alpha = 0.5f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5f)
        ) {
            Icon(
                painter = painterResource(id = company.value.logo),
                contentDescription = company.value.name,
                tint = Color(0xFF7D7E80).copy(alpha = 0.5f),
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(80.dp)
            )
        }
    }
}