package com.gregoirebonnier.cvplayerone.ui.profile

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.media.MediaPlayer
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.gregoirebonnier.cvplayerone.MainActivity
import com.gregoirebonnier.cvplayerone.R
import com.gregoirebonnier.cvplayerone.ui.NavigationItem
import com.gregoirebonnier.cvplayerone.ui.tools.ChipSkill
import com.gregoirebonnier.cvplayerone.ui.tools.getDiffYears
import com.gregoirebonnier.cvplayerone.ui.tools.modifyIf
import com.gregoirebonnier.cvplayerone.ui.tools.noRippleClickable
import kotlinx.coroutines.launch
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState
import java.util.*


class ProfileScreen(
    private val activity: MainActivity,
    private val viewModel: ProfileViewModel,
    private val navController: NavController,
) {

    /**
     *
     */
    private fun initObservers() {
        viewModel.viewModelScope.launch {
            collectStates()
        }
        viewModel.viewModelScope.launch {
            collectEffects()
        }
    }


    /**
     *
     */
    private suspend fun collectStates() {
        viewModel.uiState.collect { state ->

        }
    }

    /**
     *
     */
    private suspend fun collectEffects() {
        viewModel.effect.collect { effect ->
            when (effect) {
                ProfileContract.Effect.OnUserSendEmail -> sendEmail()
                ProfileContract.Effect.OnUserOpenLinkedIn -> openLinkedIn()
            }
        }
    }


    /**
     *
     */
    private fun updateDarkModeUI() {
        viewModel.setEvent(ProfileContract.Event.OnUserUpdateDarkMode)
    }

    /**
     * send email
     */
    private fun sendEmail() {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "gmfbonnier@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT,
                activity.getString(R.string.profileScreen_intent_mail_subject))
            intent.putExtra(Intent.EXTRA_TEXT,
                activity.getString(R.string.profileScreen_intent_mail_body))
            activity.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(activity.applicationContext, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    /**
     *
     */
    private fun openLinkedIn() {
        try {
            val linkedId = "gregoire-bonnier"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://add/%@$linkedId"))
            val packageManager = activity.applicationContext.packageManager
            val list: List<ResolveInfo> =
                packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
            if (list.isEmpty()) {
                intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.linkedin.com/profile/view?id=$linkedId"))
            }
            activity.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(activity.applicationContext, e.message, Toast.LENGTH_SHORT).show()
        }
    }


    @Composable
    fun MainScreen() {
        /**
         * observe view model
         */
        initObservers()

        val state = rememberCollapsingToolbarScaffoldState()

        val firstMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.raw_smalltown_boy)
        val secondMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.raw_my_life_be_like)

        CollapsingToolbarScaffold(
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxSize(),
            state = state,
            scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
            toolbar = {
                val textSize = (20 + (30 - 18) * state.toolbarState.progress).sp

                Column(modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()
                    .height(250.dp)
                    .road(Alignment.Center, Alignment.TopCenter),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile_picture),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .alpha(state.toolbarState.progress)
                            .size(120.dp)
                            .clip(CircleShape)
                            .border(4.dp, MaterialTheme.colors.onPrimary, CircleShape)
                    )
                }

                Text(
                    text = "Grégoire Bonnier",
                    modifier = Modifier
                        .road(Alignment.TopStart, Alignment.BottomCenter)
                        .padding(16.dp),
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = textSize,
                )

                Image(
                    painter = painterResource(R.drawable.ic_baseline_dark_mode_24),
                    contentDescription = "dark mode",
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onPrimary),
                    modifier = Modifier
                        .road(Alignment.TopEnd, Alignment.TopEnd)
                        .padding(16.dp)
                        .noRippleClickable {
                            updateDarkModeUI()
                        }
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp, 12.dp, 0.dp, 0.dp))
                    .background(MaterialTheme.colors.surface)
                    .padding(top = 24.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item {
                        Text(
                            modifier = Modifier.padding(
                                top = 16.dp,
                                bottom = 36.dp,
                                start = 24.dp,
                                end = 24.dp),
                            color = MaterialTheme.colors.onSurface,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.Center,
                            text = stringResource(id = R.string.profileScreen_description)
                        )
                    }
                    item {
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val skills = listOf(
                                "Kotlin",
                                "Compose",
                                "MVVM/MVI",
                                "Room",
                                "Retrofit",
                                "Koin",
                                "Agile",
                                "Git",
                            )
                            itemsIndexed(skills) { index, skill ->
                                Box(modifier = Modifier
                                    .padding(
                                        start = if (index == 0) 24.dp else 6.dp,
                                        end = if (index == skills.lastIndex) 24.dp else 0.dp,
                                    )
                                ) {
                                    ChipSkill(text = skill)
                                }
                            }
                            item {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_three_dots_24),
                                    contentDescription = "last item",
                                    colorFilter = ColorFilter.tint(Color.LightGray),
                                    modifier = Modifier
                                        .padding(end = 24.dp)
                                        .noRippleClickable {
                                            navController.navigate(NavigationItem.Skills.route)
                                        },
                                )
                            }
                        }
                    }
                    item {
                        Column(modifier = Modifier.padding(vertical = 36.dp)) {
                            InformationItem(
                                text = stringResource(R.string.profileScreen_informationItem_title_developer),
                                icon = R.drawable.ic_baseline_android_24,
                                action = {},
                            )
                            InformationItem(
                                text = "Paris",
                                icon = R.drawable.ic_baseline_place_24,
                                action = {},
                            )
                            InformationItem(
                                text = stringResource(
                                    id = R.string.profileScreen_informationItem_title_age,
                                    getDiffYears(Date(902440800000), Date())
                                ),
                                icon = R.drawable.ic_baseline_calendar_today_24,
                                action = {},
                            )
                            InformationItem(
                                text = "gmfbonnier@gmail.com",
                                icon = R.drawable.ic_baseline_alternate_email_24,
                                action = { viewModel.setEvent(ProfileContract.Event.OnUserClickOnEmail) },
                                hasLink = true
                            )
                            InformationItem(
                                text = stringResource(R.string.profileScreen_informationItem_title_linkedin),
                                icon = R.drawable.ic_linkedin_fill_24,
                                action = { viewModel.setEvent(ProfileContract.Event.OnUserClickOnLinkedIn) },
                                hasLink = true,
                                isLastItem = true
                            )

                        }
                    }
                    item {
                        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                            CardMusicPlayer("Smalltown Boy - Bronsky Beat", firstMediaPlayer)
                            CardMusicPlayer("My Life Be Like - Grits", secondMediaPlayer)

                        }
                    }

                }
                val colors = listOf(MaterialTheme.colors.surface, Color.Transparent)
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .background(Brush.verticalGradient(colors))
                        .align(Alignment.TopCenter)
                )
            }

        }
    }

    @Composable
    private fun InformationItem(
        text: String,
        icon: Int,
        action: () -> Unit,
        hasLink: Boolean = false,
        isLastItem: Boolean = false,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = if (isLastItem) 0.dp else 24.dp)
                .noRippleClickable {
                    action.invoke()
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (hasLink) Arrangement.SpaceBetween else Arrangement.Center,
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = "email",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .modifyIf(!hasLink) {
                        fillMaxWidth()
                    },
                maxLines = 1,
                color = MaterialTheme.colors.onSurface
            )
            if (hasLink) {
                Image(
                    painter = painterResource(R.drawable.ic_external_link_24),
                    contentDescription = "link",
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                    modifier = Modifier.size(16.dp)
                )
            }

        }
    }

    /**
     *
     *
    @Composable
    fun MainScreen() {
    val scrollState = rememberLazyListState()
    val boxHeight = remember { mutableStateOf(0f) }
    val toolbarHeight = 240.dp
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.roundToPx().toFloat() }
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }
    val nestedScrollConnection = remember {
    object : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
    val delta = available.y
    val newOffset = toolbarOffsetHeightPx.value + delta
    toolbarOffsetHeightPx.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
    boxHeight.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
    return Offset.Zero
    }
    }
    }
    Column(
    Modifier
    .fillMaxSize()
    .background(MaterialTheme.colors.primary)
    .nestedScroll(nestedScrollConnection)
    ) {
    Image(
    painter = painterResource(id = R.drawable.ic_baseline_person_24),
    contentDescription = null,
    contentScale = ContentScale.FillWidth,
    modifier = Modifier
    .height(toolbarHeight)
    .fillMaxWidth()
    .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) },
    )
    Text(
    text = "Grégoire Bonnier",
    modifier = Modifier
    .offset {
    val limit = 0
    IntOffset(
    x = 0,
    y = if (toolbarOffsetHeightPx.value.roundToInt() == limit) limit
    else toolbarOffsetHeightPx.value.roundToInt()
    )
    },
    )
    LazyColumn(
    modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()
    .heightIn(
    min = LocalConfiguration.current.screenHeightDp.dp + -boxHeight.value.dp,
    max = LocalConfiguration.current.screenHeightDp.dp
    )
    .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) }
    .background(
    MaterialTheme.colors.surface,
    RoundedCornerShape(topStart = 14.dp, topEnd = 14.dp)
    ),
    ) {
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    item {
    Text(text = "Content", modifier = Modifier.padding(20.dp))
    }
    }

    }

    }
     */


    /**
     * Music to display in info
     *
     */


    @Composable
    private fun CardMusicPlayer(titleMusic: String, mediaPlayer: MediaPlayer) {
        val isPlaying = remember { mutableStateOf(false) }
        Card(
            modifier = Modifier
                .padding(vertical = 15.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            backgroundColor = MaterialTheme.colors.surface,
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        if (isPlaying.value) R.drawable.ic_baseline_pause_circle_outline_24
                        else R.drawable.ic_baseline_play_circle_outline_24
                    ),
                    contentDescription = "play",
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                    modifier = Modifier
                        .size(30.dp)
                        .noRippleClickable {
                            if (isPlaying.value) {
                                mediaPlayer.pause()
                                isPlaying.value = false
                            } else {
                                mediaPlayer.start()
                                isPlaying.value = true
                            }
                        }
                )
                Text(text = titleMusic,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    maxLines = 1,
                    color = MaterialTheme.colors.onSurface)
            }

        }
    }


}
