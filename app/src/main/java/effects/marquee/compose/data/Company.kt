package effects.marquee.compose.data

import effects.marquee.compose.R


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