package com.aditya.d4ctask.ui.feature

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.aditya.d4ctask.R
import com.aditya.d4ctask.model.Offers
import com.aditya.d4ctask.model.getOffers

@Composable
fun Pager(modifier: Modifier = Modifier) {
    val offers = getOffers()
    val pagerState = rememberPagerState(pageCount = { offers.size })

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) { page ->
            OfferCard(offer = offers[page])
        }

        HorizontalPagerProgressBar(pagerState = pagerState, totalPages = offers.size)
    }
}


@Composable
fun HorizontalPagerProgressBar(
    pagerState: PagerState,
    totalPages: Int,
    trackWidth: Dp = 120.dp,
    trackHeight: Dp = 8.dp,
    indicatorColor: Color = Color(0xFFB7EC43),
    trackColor: Color = Color(0xFF2C2C2C)
) {
    val indicatorWidth = trackWidth / totalPages
    val animatedOffset by animateDpAsState(
        targetValue = indicatorWidth * pagerState.currentPage,
        label = "Indicator Offset"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 60.dp, bottom = 0.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.size(9.dp))


        Box(
            modifier = Modifier
                .width(trackWidth)
                .height(trackHeight)
                .clip(RoundedCornerShape(50))
                .background(trackColor)
        ) {
            Spacer(modifier = Modifier.size(9.dp))
            Box(
                modifier = Modifier
                    .offset(x = animatedOffset)
                    .width(indicatorWidth)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))
                    .background(indicatorColor)
            ) {

                Spacer(modifier = Modifier.width(8.dp))
            }
            Spacer(modifier = Modifier.size(9.dp))

        }
    }
}


@Composable
fun OfferCard(offer: Offers) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.banner_card),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.padding(46.dp)
        ) {

            Text(
                text = "GET ${offer.discountPercent} % OFF",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )

            Text(
                text = "GET ${offer.discountPercent} % OFF",
                style = TextStyle(fontSize = 14.sp),
                color = Color.White

            )

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(
                    text = "${offer.offerDate}",
                    style = TextStyle(fontSize = 24.sp),
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .background(
                            color = Color(0xFFb7ec43),
                            shape = RoundedCornerShape(18.dp)
                        )
                        .clip(RoundedCornerShape(16.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp),

                    color = Color.Black

                )

                Spacer(modifier = Modifier.weight(1f))

                AsyncImage(
                    model = R.drawable.cart,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(30.dp), colorFilter = ColorFilter.tint(Color.White)

                )

            }
        }


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderAppBar(
    title: String,
    modifier: Modifier = Modifier,
    showProfile: Boolean = true,
    showBackIcon: Boolean = false,
    backIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    onBackClick: () -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge

            )
        },
        actions = {

            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.padding(end = 6.dp)

            )


            Icon(
                imageVector = Icons.Rounded.FavoriteBorder,
                contentDescription = "Search",
                tint = Color.White, modifier = Modifier.padding(end = 6.dp)

            )


            Icon(
                imageVector = Icons.Rounded.ShoppingCart,
                contentDescription = "Shopping",
                tint = Color.White,
                modifier = Modifier.padding(end = 6.dp)


            )

        },

        navigationIcon = {
            if (showBackIcon) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = backIcon,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            } else if (showProfile) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .scale(0.9f)
                )
            }
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        )
    )
}


@Composable
fun RatingBar(
    rating: Float,
    reviewCount: Int,
    modifier: Modifier = Modifier,
    starSize: Dp = 20.dp,
    starColor: Color = Color(0xFFffd735)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        val fullStars = rating.toInt()
        val hasHalfStar = (rating - fullStars) >= 0.5f

        repeat(fullStars) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Full Star",
                tint = starColor,
                modifier = Modifier.size(starSize)
            )
        }

        if (hasHalfStar) {
            Icon(
                painterResource(R.drawable.star_half),
                contentDescription = "Half Star",
                tint = starColor,
                modifier = Modifier.size(starSize),
            )
        }

        val emptyStars = 5 - fullStars - if (hasHalfStar) 1 else 0
        repeat(emptyStars) {
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Empty Star",
                tint = starColor,
                modifier = Modifier.size(starSize)
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = "$reviewCount reviews",
             style = TextStyle(fontSize = 18.sp),
            textDecoration = TextDecoration.Underline,

            color = Color.White
        )
    }
}


@Composable
fun Headline(
    title: String,
    onSeeAllClick: () -> Unit = { },
    modifier: Modifier = Modifier,
    titleColor: Color = Color.White,
    seeAllColor: Color = Color.White
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 2.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = titleColor
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = onSeeAllClick) {
            Text(
                text = stringResource(R.string.see_all),
                style = TextStyle(fontSize = 16.sp),
                textDecoration = TextDecoration.Underline,
                color = seeAllColor
            )

        }
    }
}