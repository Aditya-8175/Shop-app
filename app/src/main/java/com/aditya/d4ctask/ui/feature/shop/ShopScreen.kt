package com.aditya.d4ctask.ui.feature.shop

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.aditya.d4ctask.R
import com.aditya.d4ctask.model.Category
import com.aditya.d4ctask.model.Product
import com.aditya.d4ctask.model.getCategory
import com.aditya.d4ctask.model.getProduct
import com.aditya.d4ctask.ui.feature.Headline
import com.aditya.d4ctask.ui.feature.Pager
import com.aditya.d4ctask.ui.feature.RatingBar
import com.aditya.d4ctask.ui.feature.ReaderAppBar

@Composable
fun ShopScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize()
    ) {

        ReaderAppBar(
            title = stringResource(R.string.shop),
            modifier = modifier,
            showProfile = false,
            showBackIcon = true,
            onBackClick = { }
        )
        Pager()
        CategoriesList()
        ProductList()
    }

}


@Composable
fun CategoriesList(
    categories: List<Category> = getCategory(),
    onCategorySelected: (Category) -> Unit = {}
) {

    Column {

        Headline(
            title = stringResource(R.string.categories)
        )

    }
    LazyRow {
        items(categories) {
            CategoryItem(category = it, onCategorySelected = onCategorySelected)
        }
    }

}

@Composable
fun CategoryItem(category: Category, onCategorySelected: (Category) -> Unit) {

    Column(
        modifier = Modifier, verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(90.dp)
                .clickable { onCategorySelected(category) }
                .shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(45.dp),
                )
                .background(color = Color.Black)
                .clip(CircleShape)
                .padding(8.dp),
        ) {

            AsyncImage(
                model = category.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center),

                )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = category.name, style = TextStyle(fontSize = 16.sp),
            color = Color.White, textAlign = TextAlign.Center
        )
    }
}


@Composable
fun ProductList(
    products: List<Product> = getProduct(),
    onRestaurantSelected: (Product) -> Unit = {}
) {
    Column {

        Headline(
            title = stringResource(R.string.new_products)
        )
    }
    LazyColumn {
        items(products) {
            ProductItem(it, onRestaurantSelected)
        }
    }
}

@Composable
fun ProductItem(product: Product, onProductSelected: (Product) -> Unit) {
    Box(
        modifier = Modifier
            .padding(vertical = 10.dp)
//            .width(250.dp)
            .fillMaxWidth()
            .height(500.dp)
    ) {

        val context = LocalContext.current


        Image(
            painter = painterResource(id = R.drawable.product_bg_card),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )

        Column(modifier = Modifier.fillMaxSize()) {


            Text(
                text = "Best Seller",
                style = TextStyle(fontSize = 16.sp),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 14.dp, vertical = 14.dp)

                    .align(Alignment.End)
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .padding(horizontal = 14.dp, vertical = 6.dp),
                color = Color(0xFFb7ec43)

            )




            AsyncImage(
                model = product.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(350.dp)
                    .align(CenterHorizontally)
                    .weight(1f),
            )

            Box(
                modifier = Modifier
                    .padding(horizontal = 17.dp, vertical = 17.dp)


            ) {
                Image(
                    painter = painterResource(id = R.drawable.product_title_card),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillBounds
                )


                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .clickable { onProductSelected(product) })
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,

                        ) {

                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.weight(1f),
                            color = Color(0xFFb7ec43)
                        )


                        val stock = if (product.stockAvailable) " In stock" else "Out of Stock"
                        val stockColor =
                            if (product.stockAvailable) Color(0xFFb7ec43) else Color.Red

                        Text(
                            text = stock,
                            style = TextStyle(fontSize = 12.sp),
                            color = stockColor
                        )


                    }

                    Text(
                        text = product.detail,
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.Gray,

                        )

                    Spacer(modifier = Modifier.size(6.dp))

                    Text(
                        text = product.benefit,
                        style = TextStyle(fontSize = 16.sp),
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                    )

                    Spacer(modifier = Modifier.size(6.dp))

                    Row {

                        Text(
                            text = "RS.${product.originalPrice}",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFF7250A3),
                        )

                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            text = "RS.${product.discountPrice}",
                            textDecoration = TextDecoration.LineThrough,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Gray,
                        )
                    }


                    Spacer(modifier = Modifier.size(6.dp))

                    RatingBar(rating = product.ratingCount, reviewCount = product.reviewCount)


                }


            }

        }


        Box(
            modifier = Modifier
                .align(TopStart)
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .size(40.dp)
                .shadow(16.dp, shape = CircleShape)
                .background(Color.Black)


        ) {
            Image(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center),
                colorFilter = ColorFilter.tint(Color(0xFfb7a2f1))
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(vertical = 17.dp, horizontal = 19.dp)
                .size(60.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFb7ec43),
                    shape = CircleShape
                )
                .clickable {
                    Toast.makeText(context, "Add to cart", Toast.LENGTH_SHORT).show()
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = "Cart Icon",
                modifier = Modifier
                    .size(28.dp)
                    .padding(2.dp)

            )
        }

    }
}


