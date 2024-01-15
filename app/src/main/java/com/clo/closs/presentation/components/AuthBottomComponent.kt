package com.clo.closs.presentation.components

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun AuthBottomComponent(modifier: Modifier = Modifier, isLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText =
        if (isLogin) "¿Ya tienes una cuenta? " else "¿Aún no tienes una cuenta? "
    val loginText = if (isLogin) "Accede" else "Regístrate"

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSurface)) {
            append(
                initialText
            )
        }
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.tertiary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = modifier,
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString
    ) { offset ->

        annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
            Log.d("ClickableTextComponent", "{${span.item}}")

            if (span.item == loginText) {
                onTextSelected(span.item)
            }
        }
    }
}