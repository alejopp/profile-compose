package com.example.profilecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecompose.ui.theme.Android
import com.example.profilecompose.ui.theme.AndroidBackground
import com.example.profilecompose.ui.theme.Montserrat
import com.example.profilecompose.ui.theme.ProfileComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AndroidBackground)
            .padding(top = 48.dp)
    ) {
        Logo(
            stringResource(R.string.full_name),
            stringResource(R.string.profession),
            AndroidBackground
        )
        Spacer(modifier = Modifier.padding(32.dp))
        ContactInfo(
            email = stringResource(R.string.email),
            githubAccount = stringResource(R.string.github),
            linkedin = stringResource(R.string.linkedin),
            backGroundColour = AndroidBackground,
            textColour = Color.White,
            iconColour = Android
        )
    }
}

@Composable
fun Logo(name: String, profession: String, backGround: Color) {
    Column(
        modifier = Modifier
            .background(backGround)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(150.dp)
        )
        Image(
            painter = painterResource(id =R.drawable.profile_tinified),
            contentDescription = stringResource(id = R.string.profile_photo),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .size(180.dp)
                .clip(RoundedCornerShape(32.dp))
        )
        Text(
            text = name,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            style = MaterialTheme.typography.body2
        )
        Text(
            text = profession,
            color = Android,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            fontFamily = Montserrat,
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }

}

@Composable
fun ContactInfo(
    email: String,
    githubAccount: String,
    linkedin: String,
    backGroundColour: Color,
    textColour: Color,
    iconColour: Color
) {
    Column(
        Modifier
            .background(backGroundColour)
            .fillMaxWidth()) {
        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Gray)
        Row(modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()) {
            Icon(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                painter = painterResource(R.drawable.ic_baseline_email_24),
                contentDescription = stringResource(R.string.email_text),
                tint = iconColour
            )
            Text(
                text = email,
                color = textColour,
                modifier = Modifier.padding(start = 32.dp)
            )
        }
        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Gray)
        Row(modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()) {
            Icon(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                painter = painterResource(R.drawable.ic_github),
                contentDescription = stringResource(R.string.email_text),
                tint = iconColour
            )
            Text(
                modifier = Modifier.padding(start = 32.dp),
                text = githubAccount,
                color = textColour
            )
        }
        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Gray)
        Row(modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()) {
            Icon(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                painter = painterResource(R.drawable.ic_icons8_linkedin_circled),
                contentDescription = stringResource(R.string.linkedin_icon),
                tint = iconColour
            )
            Text(
                modifier = Modifier.padding(start = 32.dp),
                text = linkedin,
                color = textColour
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileComposeTheme {
        ProfileScreen()
    }
}