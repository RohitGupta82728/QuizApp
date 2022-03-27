package com.example.quizapp

object setData {

    const val name:String="name"
    const val score:String="score"
    fun getQuestion(): ArrayList<QuestionData> {
        var ques: ArrayList<QuestionData> = arrayListOf()
        var q1 = QuestionData(
            "What is the Capital Of INDIA ?",
            1,
            "Uttar Pradesh",
            "Madhya Pradesh",
            "Kanpur",
            "New Delhi",
            4
        )
        ques.add(q1)

        var q2 = QuestionData(
            "Who was the first women in Space ?",
            2,
            "kalpana Chawla",
            "Sunita Williams",
            "Koneru Humpy",
            "None of these",
            1
        )
        ques.add(q2)

        var q3 = QuestionData(
            "Who wrote the Indian National Anthem ?",
            3,
            "Bakim Chandra Chatterji",
            "Rabindranath Tagore",
            "Swami Vivekanand",
            "None of the above",
            2
        )
        ques.add(q3)

        var q4 = QuestionData(
            "Who was the first President Of INDIA ?",
            4,
            "Abdul Kalam",
            "Lal Bahadur Shastri",
            "Dr. Rajendra Prasad",
            "Zakir Hussain",
            3
        )
        ques.add(q4)

        var q5 = QuestionData(
            "Who built the Jama Masjid ?",
            5,
            "Jahangir",
            "Akbar",
            "Imam Bukhari",
            "Shah Jahan",
            4
        )
        ques.add(q5)

        return ques
    }
}