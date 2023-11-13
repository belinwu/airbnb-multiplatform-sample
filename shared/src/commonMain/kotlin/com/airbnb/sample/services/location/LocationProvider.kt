package com.airbnb.sample.services.location

import kotlinx.serialization.Serializable

// Define a data class to store latitude and longitude coordinates
@Serializable
data class Location(val latitude: Double, val longitude: Double)
data class Heading(val trueHeading: Double, val magneticHeading: Double)

// Define a common class for location service
interface LocationProvider {
    suspend fun getCurrentLocation(): Location
    suspend fun currentLocation(
        errorCallback: (String) -> Unit = {},
        locationCallback: (Location?) -> Unit
    )
    suspend fun currentHeading(callback: (Heading?) -> Unit)
    suspend fun getLatestLocation(): Location?
}