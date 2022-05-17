package com.gregoirebonnier.cvplayerone.ui

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gregoirebonnier.cvplayerone.R
import com.gregoirebonnier.cvplayerone.ui.theme.CVPlayerOneTheme
import com.gregoirebonnier.cvplayerone.ui.theme.Shapes
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

class ProfileScreen() {

    @Composable
    fun MainScreen() {
        val state = rememberCollapsingToolbarScaffoldState()

        val firstMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.raw_smalltown_boy)
        val secondMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.raw_my_life_be_like)


        CollapsingToolbarScaffold(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize(),
            state = state,
            scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
            toolbar = {
                val textSize = (16 + (30 - 18) * state.toolbarState.progress).sp

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
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .alpha(state.toolbarState.progress)
                            .size(120.dp)
                            .clip(CircleShape)                       // clip to the circle shape
                            .border(2.dp, MaterialTheme.colors.onBackground, CircleShape)
                    )
                }

                Text(
                    text = "Grégoire Bonnier",
                    modifier = Modifier
                        .road(Alignment.TopStart, Alignment.BottomCenter)
                        .padding(16.dp, 16.dp, 16.dp, 16.dp),
                    color = MaterialTheme.colors.onBackground,
                    fontSize = textSize
                )
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(1) {
                    CardMusicPlayer("Smalltown Boy - Bronsky Beat", firstMediaPlayer)
                    CardMusicPlayer("My Life Be Like - Grits", secondMediaPlayer)
                }
            }
        }
    }

    @Composable
    private fun CardMusicPlayer(titleMusic: String, mediaPlayer: MediaPlayer) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
            elevation = 8.dp,
            shape = Shapes.medium.copy(CornerSize(8.dp))
        ) {

            Row(
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        if (mediaPlayer.isPlaying) R.drawable.ic_baseline_stop_24
                        else R.drawable.ic_baseline_play_arrow_24
                    ),
                    contentDescription = "play",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colors.onBackground, CircleShape)
                        .clickable {
                            if (mediaPlayer.isPlaying) mediaPlayer.pause()
                            else mediaPlayer.start()
                        }
                )
                Text(text = titleMusic, modifier = Modifier.padding(horizontal = 24.dp))
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

    @Preview
    @Composable
    fun MainScreenPreview() {
        CVPlayerOneTheme {
            MainScreen()
        }
    }


}