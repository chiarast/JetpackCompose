package at.htl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import at.htl.ui.JetpackComposeBasicTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicTheme {
                StartScreen()
            }
        }
    }
}

@Composable
fun StartScreen() {
    MaterialTheme {
        val list: MutableList<PictureItem> = mutableListOf(PictureItem("Untersberg Mountain",
            "Salzburg, Austria", "May 2018", R.drawable.landscape),
            PictureItem("National Park Swjati Hory",
                "Donetsk Oblast, Ukraine", "October 2012", R.drawable.landscape2),
            PictureItem("The Verdon Canyon",
                "Gorges du Verdon, France", "June 2016", R.drawable.landscape3),
            PictureItem("Matterhorn",
                "Switzerland", "August 2016", R.drawable.landscape4),
            PictureItem("Westcoast of Suðuroy",
                "Suðuroy, Faroe Islands", "July 2017", R.drawable.landscape5))

        LazyColumnFor(list) { item ->
            DisplayItem(item)
        }
    }
}

data class PictureItem(var name: String, var place: String, var date: String, var imageId: Int)

@Composable
fun DisplayItem(item: PictureItem){
    val typography = MaterialTheme.typography

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val imageModifier = Modifier
            .preferredHeight(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))

        Image(
            imageResource(item.imageId),
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.preferredHeight(16.dp))

        Text(item.name, style = typography.h6)
        Text(item.place, style = typography.body2)
        Text(item.date, style = typography.body2)

        Spacer(Modifier.preferredHeight(10.dp))
    }
}

@Preview
@Composable
fun DefaultPreview(){
    StartScreen()
}
