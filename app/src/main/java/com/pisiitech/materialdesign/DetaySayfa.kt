package com.pisiitech.materialdesign

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pisiitech.materialdesign.ui.theme.MaterialDesignTheme

@Composable
fun DetaySayfa(ulkeAdi:String) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = ulkeAdi, fontSize = 50.sp)
    }

}
@Preview(showBackground = true)
@Composable
fun DetaySayfaPreview() {
    MaterialDesignTheme {
        DetaySayfa(ulkeAdi = "almanya")
    }
}

