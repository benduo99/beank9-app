// Using Google's MapMarker code

package com.example.beank9.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.beank9.R
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.CameraUpdateFactory



/*
 * A simple [Fragment] subclass.
 * Use the [FeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class LocationFragment : Fragment() {
    /**
     * An activity that displays a Google map with a marker (pin) to indicate a particular location.
     */
// [START maps_marker_on_map_ready]
    class MapsMarkerActivity : AppCompatActivity(), OnMapReadyCallback {

        // [START_EXCLUDE]
        // [START maps_marker_get_map_async]
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            // Retrieve the content view that renders the map.
            setContentView(R.layout.fragment_location) //unsure about this line and the reference

            // Get the SupportMapFragment and request notification when the map is ready to be used.
            val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as? SupportMapFragment
            mapFragment?.getMapAsync(this)
        }
        // [END maps_marker_get_map_async]
        // [END_EXCLUDE]

        // [START maps_marker_on_map_ready_add_marker]
        override fun onMapReady(googleMap: GoogleMap) {
            val robot = LatLng(-33.852, 151.211)
            googleMap.addMarker(
                MarkerOptions()
                    .position(robot)
                    .title("beank9 location")
            )
            // [START_EXCLUDE silent]
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(robot))
            // [END_EXCLUDE]
        }
        // [END maps_marker_on_map_ready_add_marker]
    }
// [END maps_marker_on_map_ready]

}