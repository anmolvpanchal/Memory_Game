package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.grid_layout_4x4.*
import kotlinx.android.synthetic.main.grid_layout_4x4.button_back
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton1
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton10
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton2
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton3
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton4
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton5
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton6
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton7
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton8
import kotlinx.android.synthetic.main.grid_layout_4x4.imageButton9

class GridFourCrossFour : AppCompatActivity() {
    private lateinit var buttons: List<ImageButton>
    private lateinit var cards: List<MemoryCard>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid_layout_4x4)

        button_back.setOnClickListener {
            finish()
        }
        val images = mutableListOf(R.drawable.memory_bat_card_front, R.drawable.memory_cat_card_front,
            R.drawable.memory_cow_card_front, R.drawable.memory_dragon_front, R.drawable.memory_garbagemancard_front,
        R.drawable.memory_ghostdogcard_front, R.drawable.memory_hencard_front , R.drawable.memory_pigcard_front)
        images.addAll(images)
        images.shuffle()

        buttons = listOf(imageButton1, imageButton2, imageButton3, imageButton4, imageButton5,
            imageButton6, imageButton7, imageButton8, imageButton9,  imageButton10 ,imageButton11, imageButton12, imageButton13,
            imageButton14, imageButton15, imageButton16)

        cards = buttons.indices.map { index ->
            MemoryCard(images[index])
        }

        val updatingMethods = UpdatingMethods(this,cards)

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                updatingMethods.updateModels(index)
                updatingMethods.updateViews(buttons)
            }
        }
    }
}