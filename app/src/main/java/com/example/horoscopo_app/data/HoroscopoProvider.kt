package com.example.horoscopo_app.data

import android.app.VoiceInteractor
import android.util.Log
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HoroscopoProvider {

    suspend fun descripcionHoroscopo(horoscopeId: String): String? {

        val url = URL("https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=$horoscopeId&day=TODAY") // URL de la API o endpoint


/*
        val client = OkHttpClient()

        // Construir solicitud con el encabezado de idioma
        val request = Request.Builder()
            .url("https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=$sign")
            .header("Accept-Language", "es") // Establecer el idioma en español
            .build()

        // Realizar la solicitud de forma síncrona
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw Exception("Unexpected code $response")

            // Obtener el cuerpo de la respuesta como texto
            val responseBody = response.body?.string()

            // Imprimir el resultado
            println(responseBody)
        }

       */

        var connection: HttpsURLConnection? = null
        var result: String? = null


        try {

            // Crear la conexión HTTP
            connection = url.openConnection() as HttpsURLConnection
            connection.requestMethod = "GET" // Establecer el método GET
            connection.setRequestProperty(
                "Accept",
                "application/json"
            )
            // Leer la respuesta de la solicitud
            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                val response = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    response.append(line)
                }

                reader.close()
                println("Respuesta: ${response.toString()}")
                val responseObject: JSONObject = JSONObject(response.toString())
                // data y horoscope_data salen del JSON devuelto son los 2 valores que devuelve la API
                result = responseObject.getJSONObject("data").getString("horoscope_data")
            } else {
                println("Error en la solicitud. Código de respuesta: $responseCode")
            }
        }
            catch(e:Exception)
            {
                Log.e("HTTP", "Error en la solicitud. ", e)
            }
            finally
            {
                // Cerrar la conexión
                connection?.disconnect()
            }

            return result

    }
}





