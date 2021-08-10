package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.grid_layout_5x2.*

class GridFiveCrossTwo : AppCompatActivity() {
    private lateinit var buttons: List<ImageButton>
    private lateinit var cards: List<MemoryCard>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid_layout_5x2)

        button_back.setOnClickListener {
            finish()
        }

        val images = mutableListOf(R.drawable.memory_bat_card_front, R.drawable.memory_cat_card_front,
            R.drawable.memory_cow_card_front, R.drawable.memory_dragon_front, R.drawable.memory_garbagemancard_front)
        // Add each image twice so we can create pairs
        images.addAll(images)
        // Randomize the order of images
        images.shuffle()

        buttons = listOf(imageButton1, imageButton2, imageButton3, imageButton4, imageButton5,
            imageButton6, imageButton7, imageButton8, imageButton9,  imageButton10)

        cards = buttons.indices.map { index ->
            MemoryCard(images[index])
        }

        val updatingMethodes = UpdatingMethods(this,cards)

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                // Update models
                updatingMethodes.updateModels(index)
                // Update the UI for the game
                updatingMethodes.updateViews(buttons)
            }
        }
    }
}