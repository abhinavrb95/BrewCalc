package com.abhi.brewcalc

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import java.util.Locale

class MainActivity : Activity() {

    private lateinit var beansInput: EditText
    private lateinit var ratioInput: EditText
    private lateinit var results: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        beansInput = findViewById(R.id.beansInput)
        ratioInput = findViewById(R.id.ratioInput)
        results = findViewById(R.id.results)

        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun afterTextChanged(s: Editable?) = recalculate()
        }
        beansInput.addTextChangedListener(watcher)
        ratioInput.addTextChangedListener(watcher)
        recalculate()
    }

    private fun recalculate() {
        val beans = beansInput.text.toString().toDoubleOrNull()
        val ratio = ratioInput.text.toString().toDoubleOrNull()

        if (beans == null || ratio == null || beans <= 0 || ratio <= 0) {
            results.text = "Enter bean weight and ratio."
            return
        }

        val totalWater = beans * ratio
        val totalBloom = totalWater * 0.4
        val bloom1 = totalBloom * (50.0 / 120.0)
        val bloom2 = totalBloom * (70.0 / 120.0)
        val phase2 = totalWater * 0.6

        results.text = buildString {
            appendLine(row("Total water", totalWater))
            appendLine(row("Total bloom", totalBloom))
            appendLine(row("  Bloom 1", bloom1))
            appendLine(row("  Bloom 2", bloom2))
            append(row("Total phase 2", phase2))
        }
    }

    private fun row(label: String, grams: Double) =
        String.format(Locale.US, "%-14s %7.1f g", label, grams)
}
