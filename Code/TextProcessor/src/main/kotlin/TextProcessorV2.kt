class TextProcessorV2 {
    fun processText(text: String): List<WordFreq> {
        return text.clend()
            .split(' ')
            .getWordCount()
            .mapToList { WordFreq(it.key,it.value) }
            .sortedByDescending { it.frequency }

    }

    private fun<T> Map<String,Int>.mapToList(transform:(Map.Entry<String,Int>)->T):MutableList<T>{
        val list= mutableListOf<T>()
        for (entry in this) {
            if (entry.key=="")
                continue
            val freq=transform(entry)
            list.add(freq)
        }
        return list
    }

    private fun List<String>.getWordCount(): Map<String, Int> {
        val map= hashMapOf<String,Int>()
        for (word in this) {
            val count=map.getOrDefault(word,0)
            map[word]=count+1
        }
        return map
    }

    private fun String.clend(): String {
        return this.replace("[^A-Za-z]".toRegex()," ").trim()
    }
}