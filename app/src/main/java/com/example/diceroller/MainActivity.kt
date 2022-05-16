package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.diceroller.databinding.ActivityMainBinding
import java.util.*

/*
* MainActivity наследует/расширяет AppCompatActivity()
* AppCompatActivity() - это подкласс Android, который дает нам доступ к современным функциям Android, предотвращая обратную совместимость со старыми версиями Android
* C функциональной точки зрения, всегда нужно использовать AppCompatActivity чтобы сделать приложение доступным для максимально возможного количества устройст и пользователей
* Activity не используют конструктор для своей настройки
* Вместо этого в процессе настройки вызывается ряд предопределенных методов
* Один из таких методов является onCreate()
* В onCreate() - указывается какой макет связан с актиностью
* Его так же нужно Inflate (наполнять/раздувать)
* setContentView(макет который Activity будет наполнять, а затем рисовать на экране) - делает обе эти вещи
* */
class MainActivity : AppCompatActivity() {
	lateinit var binding: ActivityMainBinding
	override fun onCreate(s: Bundle?) {
		super.onCreate(s)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		// Получаем  ссылку на кнопку и присваиваем ее неизменяемой val переменной с именем rollButton
		val rollButton: Button = binding.rollButton
		rollButton.setOnClickListener {
			// для этого метода требуются 3 вещи
			// - class, называемый context(^C)
			// - "message"
			// - duration
			Toast.makeText(this, "Btn Click", Toast.LENGTH_SHORT).show()

			rollDice()
		}

	}

	private fun rollDice() {
		val resultText: TextView = binding.textView
		// (рандомность будет от 0 - 5, что бы было 1 - 6, нужно +1)
		val randomInt = Random().nextInt(6) + 1
		resultText.text = randomInt.toString()
	}
}
/*
* Тексы, картинки, кнопки и тд. назваются View(представлениями)
* Активность макета связана с процессором, известным как Layout Inflation (наполнение/раздувание макета)
* Во время расширение макета view(представления), определенные в файлах макета xml, превращаются или расширяются в View Objects(объкты представления) Kotlin в память
* Зате MainActivity может начать рисовать эти View Object (объекты представления) на экране
*
* (^C) - Object context позволяет общаться и получать информацию о текущем состоянии системы Android
* MainActivity - является подклассом context
*/