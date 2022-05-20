package com.gregoirebonnier.cvplayerone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.gregoirebonnier.cvplayerone.ui.tools.ChipSkill

class SkillScreen() {

    @Composable
    fun MainScreen() {
        Column(modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()) {
            FlowRow(
                mainAxisSize = SizeMode.Expand,
                modifier = Modifier,
                mainAxisSpacing = 8.dp,
            ) {
                ChipSkill("Couroutines Flow")
                ChipSkill("Git")
                ChipSkill("Kotlin")
                ChipSkill("Couroutines Flow")
                ChipSkill("Git")
                ChipSkill("Kotlin")
                ChipSkill("Git")
                ChipSkill("Kotlin")
                ChipSkill("Git")
                ChipSkill("Kotlin")
                ChipSkill("Couroutines Flow")
                ChipSkill("Git")
                ChipSkill("Kotlin")
            }
        }
    }


}