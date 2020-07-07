package prc94.app.diceroller

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import prc94.app.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val sameResultToast by lazy { Toast.makeText(this, R.string.same_result, Toast.LENGTH_SHORT) }
    private val rand = Random.Default
    private var lastResult = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val randNum = rand.nextInt(1, 7)

        if (randNum == lastResult) {
            sameResultToast.show()
            return
        }

        lastResult = randNum

        val imageResourceId =
            when (randNum) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> throw IllegalStateException()
            }

        binding.diceImage.setImageResource(imageResourceId)
    }
}