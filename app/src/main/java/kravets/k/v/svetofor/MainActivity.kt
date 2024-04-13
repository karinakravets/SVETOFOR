package kravets.k.v.svetofor

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kravets.k.v.svetofor.databinding.ActivityMainBinding

class TrafficLightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentLight = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            when (currentLight) {
                0 -> {
                    binding.imageView.setColorFilter(Color.GRAY)
                    binding.imageView2.setColorFilter(Color.YELLOW)
                    currentLight = 1
                }

                1 -> {
                    binding.imageView2.setColorFilter(Color.GRAY)
                    binding.imageView3.setColorFilter(Color.GREEN)
                    currentLight = 2
                }

                2 -> {
                    binding.imageView3.setColorFilter(Color.GRAY)
                    binding.imageView2.setColorFilter(Color.YELLOW)
                    currentLight = 3
                }

                3 -> {
                    binding.imageView2.setColorFilter(Color.GRAY)
                    binding.imageView.setColorFilter(Color.RED)
                    currentLight = 0
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentLight", currentLight)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currentLight = savedInstanceState.getInt("currentLight")
        when (currentLight) {
            0 -> binding.imageView.setColorFilter(Color.RED)
            1 -> binding.imageView2.setColorFilter(Color.YELLOW)
            2 -> binding.imageView3.setColorFilter(Color.GREEN)
            3 -> binding.imageView.setColorFilter(Color.RED)
        }
    }
}