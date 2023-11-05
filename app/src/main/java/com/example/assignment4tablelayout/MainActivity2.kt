package com.example.assignment4tablelayout

import AndroidItem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var editTextVersion: EditText
    private lateinit var editTextCodeName: EditText
    private lateinit var addButton: Button
    private lateinit var tableLayout: TableLayout
    private val androidItems = mutableListOf<AndroidItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextVersion = findViewById(R.id.editTextVersion)
        editTextCodeName = findViewById(R.id.editTextCodeName)
        addButton = findViewById(R.id.addButton)
        tableLayout = findViewById(R.id.tableLayout)

        addButton.setOnClickListener {
            val version = editTextVersion.text.toString()
            val codeName = editTextCodeName.text.toString()

            if (version.isNotEmpty() && codeName.isNotEmpty()) {
                val newRow = TableRow(this)
                val versionTextView = TextView(this)
                versionTextView.text = version
                newRow.addView(versionTextView)

                val codeNameTextView = TextView(this)
                codeNameTextView.text = codeName
                newRow.addView(codeNameTextView)

                tableLayout.addView(newRow)

                // Clear the EditTexts
                editTextVersion.text.clear()
                editTextCodeName.text.clear()
            }

        }

    }
    private fun addStaticItems() {
        val staticRow1 = TableRow(this)
        val staticVersion1 = "Static Version 1"
        val staticCodeName1 = "Static CodeName 1"

        val staticRow2 = TableRow(this)
        val staticVersion2 = "Static Version 2"
        val staticCodeName2 = "Static CodeName 2"

        val staticVersionTextView1 = TextView(this)
        val staticCodeNameTextView1 = TextView(this)
        val staticVersionTextView2 = TextView(this)
        val staticCodeNameTextView2 = TextView(this)

        staticVersionTextView1.text = staticVersion1
        staticCodeNameTextView1.text = staticCodeName1
        staticVersionTextView2.text = staticVersion2
        staticCodeNameTextView2.text = staticCodeName2

        staticRow1.addView(staticVersionTextView1)
        staticRow1.addView(staticCodeNameTextView1)
        staticRow2.addView(staticVersionTextView2)
        staticRow2.addView(staticCodeNameTextView2)

        tableLayout.addView(staticRow1)
        tableLayout.addView(staticRow2)

        // Add static items to the list
        androidItems.add(AndroidItem(staticVersion1, staticCodeName1))
        androidItems.add(AndroidItem(staticVersion2, staticCodeName2))
    }
}