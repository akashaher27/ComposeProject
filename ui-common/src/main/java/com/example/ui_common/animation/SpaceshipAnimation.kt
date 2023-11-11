package com.example.ui_common.animation

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.ui_common.R
import kotlin.math.roundToInt

@Composable
fun Content() {
    var boxLayoutDetail by remember {
        mutableStateOf(BoxLayoutDetail.DEFAULT)
    }
    var index by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 100.dp)
                    .size(200.dp)
                    .background(Color.Cyan)
                    .onGloballyPositioned { coordinate ->
                        boxLayoutDetail = boxLayoutDetail.copy(
                            offset = coordinate.positionInRoot(),
                            height = coordinate.size.height,
                            width = coordinate.size.width
                        )
                    }
            )
        }
    }
    val ld = LocalDensity.current
    val space = with(ld) {
        (boxLayoutDetail.width - 70.dp.toPx()) / 2
    }
    val list = listOf(
        SpaceshipAnimationSpec(
            offset = Offset(
                x = boxLayoutDetail.offset.x + space,
                y = boxLayoutDetail.offset.y + (boxLayoutDetail.height) * 4
            ),
            animationSpec = TweenSpec(
                durationMillis = 0,
                easing = FastOutSlowInEasing
            ),
            boostSpecs = BoostSpecs(
                isBoostEnable = true,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 1000),
                    repeatMode = RepeatMode.Restart
                ),
                initialSize = listOf(40f, 60f, 50f),
                targetSize = 70f
            )
        ),
        SpaceshipAnimationSpec(
            offset = Offset(
                x = boxLayoutDetail.offset.x + space,
                y = boxLayoutDetail.offset.y + space
            ),
            animationSpec = TweenSpec(
                durationMillis = 1500,
                easing = FastOutSlowInEasing
            ),
            boostSpecs = BoostSpecs(
                isBoostEnable = true,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 500),
                    repeatMode = RepeatMode.Restart
                ),
                initialSize = listOf(55f, 50f, 60f),
                targetSize = 70f
            )
        ),
        SpaceshipAnimationSpec(
            offset = Offset(
                x = boxLayoutDetail.offset.x + space,
                y = boxLayoutDetail.offset.y + (boxLayoutDetail.height * 0.50f)
            ),
            animationSpec = TweenSpec(
                delay = 2000,
                durationMillis = 500,
                easing = LinearOutSlowInEasing
            ),
            boostSpecs = BoostSpecs(
                isBoostEnable = true,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 500),
                    repeatMode = RepeatMode.Restart
                ),
                initialSize = listOf(20f, 30f),
                targetSize = 40f
            )
        ),
        SpaceshipAnimationSpec(
            offset = Offset(
                x = boxLayoutDetail.offset.x + space,
                y = boxLayoutDetail.offset.y - boxLayoutDetail.height
            ),
            animationSpec = TweenSpec(
                durationMillis = 400,
                easing = FastOutLinearInEasing
            ),
            boostSpecs = BoostSpecs(
                isBoostEnable = true,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 500),
                    repeatMode = RepeatMode.Reverse
                ),
                initialSize = listOf(70f, 80f),
                targetSize = 100f
            )
        )
    )
    if (index < list.size) {
        SpaceShipAnimation(
            spaceshipAnimationSpec = list[index],
            onFinishAnimation = {
                index++
            }
        )
    }

}

@Composable
private fun SpaceShipAnimation(
    spaceshipAnimationSpec: SpaceshipAnimationSpec,
    onFinishAnimation: () -> Unit
) {
    val animateRocketOffset by animateOffsetAsState(
        targetValue = spaceshipAnimationSpec.offset,
        animationSpec = spaceshipAnimationSpec.animationSpec,
        finishedListener = { onFinishAnimation() }
    )
    SpaceShip(
        modifier = Modifier
            .absoluteOffset {
                IntOffset(
                    x = animateRocketOffset.x.roundToInt(),
                    y = animateRocketOffset.y.roundToInt()
                )
            },
        boostSpecs = spaceshipAnimationSpec.boostSpecs
    )
}

@Composable
private fun SpaceShip(
    modifier: Modifier = Modifier,
    boostSpecs: BoostSpecs
) {
    val infiniteHeightTran = rememberInfiniteTransition()
    val animateHeight = infiniteHeightTran.animateFloat(
        initialValue = boostSpecs.initialSize.random(),
        targetValue = boostSpecs.targetSize,
        animationSpec = boostSpecs.animationSpec

//        infiniteRepeatable(
//            animation = tween(durationMillis = 1000),
//            repeatMode = RepeatMode.Restart
//        )
    )
    Column(
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .size(70.dp),
            painter = painterResource(id = R.drawable.starfighter),
            contentDescription = null
        )
        Spacer(
            modifier = modifier
                .size(4.dp)
        )
        if (boostSpecs.isBoostEnable) {
            Image(
                modifier = Modifier
                    .width(70.dp)
                    .height(animateHeight.value.dp),
                painter = painterResource(id = R.drawable.flame2),
                contentDescription = null
            )
        }
    }
}

data class BoxLayoutDetail(
    val offset: Offset,
    val height: Int,
    val width: Int
) {
    companion object {
        val DEFAULT = BoxLayoutDetail(
            offset = Offset(x = 0f, y = 0f),
            height = 0,
            width = 0
        )
    }
}

data class SpaceshipAnimationSpec(
    val offset: Offset,
    val animationSpec: AnimationSpec<Offset>,
    val boostSpecs: BoostSpecs
)

data class BoostSpecs(
    val isBoostEnable: Boolean = true,
    val animationSpec: InfiniteRepeatableSpec<Float>,
    val initialSize: List<Float>,
    val targetSize: Float
)