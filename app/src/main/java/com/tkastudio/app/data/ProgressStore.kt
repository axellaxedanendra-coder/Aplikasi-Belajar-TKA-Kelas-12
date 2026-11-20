package com.tkastudio.app.data

import android.content.Context
import com.tkastudio.app.model.AnswerRecord
import org.json.JSONArray
import org.json.JSONObject

class ProgressStore(context: Context) {
    private val prefs = context.getSharedPreferences("tka_studio_prefs", Context.MODE_PRIVATE)

    fun loadMasteredIds(): Set<String> {
        val raw = prefs.getString("mastered_ids", "[]") ?: "[]"
        return try {
            val arr = JSONArray(raw)
            buildSet {
                for (i in 0 until arr.length()) {
                    add(arr.getString(i))
                }
            }
        } catch (_: Exception) {
            emptySet()
        }
    }

    fun saveMasteredIds(ids: Set<String>) {
        val arr = JSONArray()
        ids.forEach { arr.put(it) }
        prefs.edit().putString("mastered_ids", arr.toString()).apply()
    }

    fun loadAnswersByPack(): Map<String, Map<String, AnswerRecord>> {
        val raw = prefs.getString("answers_by_pack", "{}") ?: "{}"
        return try {
            val root = JSONObject(raw)
            val result = mutableMapOf<String, Map<String, AnswerRecord>>()
            val keys = root.keys()
            while (keys.hasNext()) {
                val packId = keys.next()
                val packObj = root.optJSONObject(packId) ?: continue
                val map = mutableMapOf<String, AnswerRecord>()
                val qKeys = packObj.keys()
                while (qKeys.hasNext()) {
                    val qId = qKeys.next()
                    val rec = packObj.optJSONObject(qId) ?: continue
                    map[qId] = AnswerRecord(
                        selectedIndex = rec.optInt("selectedIndex", 0),
                        isCorrect = rec.optBoolean("isCorrect", false)
                    )
                }
                result[packId] = map
            }
            result
        } catch (_: Exception) {
            emptyMap()
        }
    }

    fun saveAnswersByPack(answers: Map<String, Map<String, AnswerRecord>>) {
        val root = JSONObject()
        answers.forEach { (packId, qMap) ->
            val packObj = JSONObject()
            qMap.forEach { (qId, rec) ->
                val recObj = JSONObject().apply {
                    put("selectedIndex", rec.selectedIndex)
                    put("isCorrect", rec.isCorrect)
                }
                packObj.put(qId, recObj)
            }
            root.put(packId, packObj)
        }
        prefs.edit().putString("answers_by_pack", root.toString()).apply()
    }
}
