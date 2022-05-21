package com.gregoirebonnier.cvplayerone.ui.experience

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.gregoirebonnier.cvplayerone.R
import com.gregoirebonnier.cvplayerone.domain.model.CompanyModel
import com.gregoirebonnier.cvplayerone.ui.tools.ExpandableCard

class ExperienceScreen() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreen() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Experiences",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.onPrimary,
                        )
                    },
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            content = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.surface)
                ) {
                    item {
                        ExpandableCard(
                            header = companyOptimetriks.name,
                            subtitle = companyOptimetriks.role,
                            date = companyOptimetriks.period,
                            description = companyOptimetriks.missionList,
                            skills = companyOptimetriks.skillsList,
                            imageRes = companyOptimetriks.imageRes,
                            isHorizontalChips = true,
                        )
                        ExpandableCard(
                            header = companyWonderstudios2.name,
                            subtitle = companyWonderstudios2.role,
                            date = companyWonderstudios2.period,
                            description = companyWonderstudios2.missionList,
                            skills = companyWonderstudios2.skillsList,
                            imageRes = companyWonderstudios2.imageRes,
                            isHorizontalChips = true,
                        )
                        ExpandableCard(
                            header = companyWonderstudios1.name,
                            subtitle = companyWonderstudios1.role,
                            date = companyWonderstudios1.period,
                            description = companyWonderstudios1.missionList,
                            skills = companyWonderstudios1.skillsList,
                            imageRes = companyWonderstudios1.imageRes,
                            isHorizontalChips = true,
                        )
                    }

                }
            }
        )

    }


    private val companyOptimetriks = CompanyModel(
        name = "Optimetriks",
        role = "Android Developer",
        period = "2020-2022",
        missionList = listOf(
            "Contributing to the modularisation of the Android application",
            "Improving application quality",
            "Facilitating meetings in accordance with SrumBan agility",
            "Participating in the design phase",
            "Writing the technical specifications",
        ),
        skillsList = listOf(
            "Kotlin",
            "Java",
            "Couroutines Flow",
            "MVVM",
            "MVI",
            "Clean Architecture",
            "Jetpack Compose",
            "Databinding",
            "Espresso",
            "Mockk",
            "Kakao",
            "Room",
            "Retrofit",
            "Koin Injection",
            "Koin Test",
            "Git",
            "Agility Management",
            "Jira",
        ),
        imageRes = R.drawable.fieldpro,
    )

    private val companyWonderstudios2 = CompanyModel(
        name = "Wonderstudios",
        role = "Account Manager",
        period = "2019-2020",
        missionList = listOf(
            "Negotiation and customer relations",
            "UX & UI design consulting",
            "Creation & production of web content (website, social media, display, videos)",
            "Monitoring, reporting and strategic recommendations",
        ),
        skillsList = listOf(
            "Team management",
            "Planning",
            "Quotation",
            "Invoicing",
            "Acceptance, support call for tender",
            "Retroplanning of projects"
        ),
        imageRes = R.drawable.wonderstudios,
    )

    private val companyWonderstudios1 = CompanyModel(
        name = "Wonderstudios",
        role = "Web Developer",
        period = "2018-2019",
        missionList = listOf(
            "Development of advertising banners for the web",
            "Graphic design (creation of static images and website skins)",
            "Training as a Digital Project Manager",
        ),
        skillsList = listOf(
            "HTML",
            "CSS",
            "JS",
            "Photoshop",
            "Illustrator",
            "Account Manager training",
        ),
        imageRes = R.drawable.wonderstudios,
    )
}