
class TextProcessorV1 {
    fun processText(text: String): List<WordFreq> {
        val cleaned = clend(text)
        val words = cleaned.split(' ')
        val map = getWordCount(words)
        return sortByFrequency(map)
    }

    private fun sortByFrequency(map: Map<String, Int>): List<WordFreq> {
        val list= mutableListOf<WordFreq>()
        for (entry in map) {
            if (entry.key=="")
                continue
            list.add(WordFreq(entry.key,entry.value))
        }
        list.sortByDescending {
            it.frequency
        }
        return list
    }

    private fun getWordCount(words: List<String>): Map<String, Int> {
        val map= hashMapOf<String,Int>()
        for (word in words) {
            val count=map.getOrDefault(word,0)
            map[word]=count+1
        }
        return map
    }

    private fun clend(text: String): String {
        return text.replace("[^A-Za-z]".toRegex()," ").trim()
    }
}
data class WordFreq(val word: String, val frequency: Int)