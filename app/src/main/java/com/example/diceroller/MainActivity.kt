package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
	// (^L)
	lateinit var binding: ActivityMainBinding
	// (^v)
	lateinit var resultImage: ImageView

		override fun onCreate(s: Bundle?) {
		super.onCreate(s)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		// Получаем  ссылку на кнопку и присваиваем ее неизменяемой val переменной с именем rollButton
		val rollButton: Button = binding.rollButton
		rollButton.setOnClickListener {

			rollDice()
		}
		resultImage = binding.imgViewDice
	}

	private fun rollDice() {
		// (рандомность будет от 0 - 5, что бы было 1 - 6, нужно +1)
		val randomInt = Random().nextInt(6) + 1
		val drawableResource =  when (randomInt){
			1 -> R.drawable.dice_1
			2 -> R.drawable.dice_2
			3 -> R.drawable.dice_3
			4 -> R.drawable.dice_4
			5 -> R.drawable.dice_5
			else -> R.drawable.dice_6
		}
		resultImage.setImageResource(drawableResource)
		// (^T)
		Toast.makeText(this, "Dropped: ${drawableResource}", Toast.LENGTH_SHORT).show()
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
*
* (^T)для этого метода требуются 3 вещи
* class, называемый context(^C)
* "message"
* duration
*
* findViewById() - нужно свести к минимуму, потому что всякий раз когда вызывается findViewById, он ищет эту иерархию представлений, что является дорогостоящей операцией.
* В маленьком приложении это не заметно, но в большом приложении на слабот телефоне, будет ощутимая задержка приложения.
* (^v)View layout(редставления макета), недоступны в памяти до тех пор, пока они не будут расширены этим вызовом setContenView
* По этому не получится инициализировать View пока это не произойдет.
* Так что поле view нужно сделать null что бы ему можно было присвоить начально значение
* (^L) * lateinit - сообщает компилятору, что variable будет инициализирована(не будет равна null) перед вызовом каких-либо операция над ней
* по этому можно не писать var resultImage: ImageView? = null
* Можно рассматривать его как не-null везде, где его использовать
*
*
*/