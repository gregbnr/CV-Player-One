package com.gregoirebonnier.cvplayerone.ui

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gregoirebonnier.cvplayerone.R
import com.gregoirebonnier.cvplayerone.ui.tools.noRippleClickable


class BonusScreen() {

    @OptIn(ExperimentalMaterialApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreen() {

        val firstMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.raw_smalltown_boy)
        val secondMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.raw_my_life_be_like)

        val isFirstMediaPlaying = remember { mutableStateOf(false) }
        val isSecondMediaPlaying = remember { mutableStateOf(false) }


        DisposableEffect(LocalContext.current) {
            onDispose {
                firstMediaPlayer.stop()
                secondMediaPlayer.stop()
            }
        }


        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Bonus",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.onPrimary,
                        )
                    },
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            content = {

                var state by remember { mutableStateOf(CardFace.Front) }

                Surface(modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .padding(24.dp)) {
                    FlipCard(
                        cardFace = state,
                        back = {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .noRippleClickable {
                                            state = state.next
                                        },
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                                        colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                                        contentDescription = "Next",
                                        modifier = Modifier
                                            .rotate(90f)
                                            .size(50.dp)
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .weight(.99f)
                                        .padding(24.dp),
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .weight(.5f)
                                            .fillMaxWidth(),
                                        verticalArrangement = Arrangement.SpaceEvenly,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Smalltown Boy - Bronsky Beat",
                                            color = MaterialTheme.colors.onSurface,
                                            textAlign = TextAlign.Center,
                                            fontSize = 24.sp,
                                            modifier = Modifier.padding(24.dp)
                                        )
                                        Image(
                                            painter = painterResource(
                                                if (isFirstMediaPlaying.value) R.drawable.ic_baseline_pause_24
                                                else R.drawable.ic_baseline_play_arrow_24
                                            ),
                                            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                                            contentDescription = "Play",
                                            modifier = Modifier
                                                .size(70.dp)
                                                .noRippleClickable {
                                                    if (isFirstMediaPlaying.value) {
                                                        firstMediaPlayer.pause()
                                                        isFirstMediaPlaying.value = false
                                                    } else {
                                                        if (secondMediaPlayer.isPlaying) {
                                                            secondMediaPlayer.pause()
                                                            isSecondMediaPlaying.value = false
                                                        }
                                                        isFirstMediaPlaying.value = true
                                                        firstMediaPlayer.start()
                                                    }
                                                }
                                        )
                                    }
                                    Divider(color = Color.LightGray)
                                    Column(
                                        modifier = Modifier
                                            .weight(.5f)
                                            .fillMaxWidth(),
                                        verticalArrangement = Arrangement.SpaceEvenly,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "My Life Be Like - Grits",
                                            color = MaterialTheme.colors.onSurface,
                                            textAlign = TextAlign.Center,
                                            fontSize = 24.sp,
                                            modifier = Modifier.padding(24.dp)
                                        )
                                        Image(
                                            painter = painterResource(
                                                if (isSecondMediaPlaying.value) R.drawable.ic_baseline_pause_24
                                                else R.drawable.ic_baseline_play_arrow_24
                                            ),
                                            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                                            contentDescription = "Play",
                                            modifier = Modifier
                                                .size(70.dp)
                                                .noRippleClickable {
                                                    if (isSecondMediaPlaying.value) {
                                                        secondMediaPlayer.pause()
                                                        isSecondMediaPlaying.value = false
                                                    } else {
                                                        if (firstMediaPlayer.isPlaying) {
                                                            firstMediaPlayer.pause()
                                                            isFirstMediaPlaying.value = false
                                                        }
                                                        isSecondMediaPlaying.value = true
                                                        secondMediaPlayer.start()
                                                    }
                                                }
                                        )
                                    }
                                }
                            }
                        },
                        front = {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .weight(.99f)
                                        .padding(24.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.bonusScreen_ready),
                                        fontSize = 26.sp,
                                        fontStyle = FontStyle.Italic,
                                        textAlign = TextAlign.Center,
                                        color = MaterialTheme.colors.onSurface,
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .noRippleClickable {
                                            state = state.next
                                        },
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                                        colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                                        contentDescription = "Next",
                                        modifier = Modifier
                                            .rotate(-90f)
                                            .size(50.dp)
                                    )
                                }
                            }
                        }
                    )
                }

            }
        )
    }
}

enum class CardFace(val angle: Float) {
    Front(0f) {
        override val next: CardFace
            get() = Back
    },
    Back(180f) {
        override val next: CardFace
            get() = Front
    };

    abstract val next: CardFace
}


@ExperimentalMaterialApi
@Composable
fun FlipCard(
    cardFace: CardFace,
    modifier: Modifier = Modifier,
    back: @Composable () -> Unit = {},
    front: @Composable () -> Unit = {},
) {
    val rotation = animateFloatAsState(
        targetValue = cardFace.angle,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing,
        )
    )
    Card(
        modifier = modifier
            .background(MaterialTheme.colors.surface)
            .graphicsLayer {
                rotationY = rotation.value
                cameraDistance = 100f * density
            },
        shape = RoundedCornerShape(12.dp),
        elevation = 0.dp,
        border = BorderStroke(1.dp, Color.LightGray),
    ) {
        if (rotation.value <= 90f) {
            Box(
                Modifier.fillMaxSize()
            ) {
                front()
            }
        } else {
            Box(
                Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = 180f
                    },
            ) {
                back()
            }
        }
    }
}
