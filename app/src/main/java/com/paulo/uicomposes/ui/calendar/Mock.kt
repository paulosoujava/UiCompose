package com.paulo.uicomposes.ui.calendar

data class Test(
    val section: String,
    val hour: String,
    val typeService: String,
    val codeOfType: String,
)

object Mock {

    fun get():  List<Test>{
        val test = arrayListOf<Test>()
            test.add(mockTest("SEG 16", "13:30")  )
            test.add(mockTest("SEG 16", "17:00")  )
            test.add(mockTest("QUA 18", "13:30")  )
            test.add(mockTest("SEX 20", "13:30")  )
            test.add(mockTest("SEX 20", "16:30")  )
            test.add(mockTest("SEX 20", "17:30")  )
            test.add(mockTest("SEX 20", "20:30")  )
            test.add(mockTest("SEG 23", "20:30")  )
            test.add(mockTest("SEG 23", "20:30")  )
            test.add(mockTest("TER 23", "09:30")  )
            test.add(mockTest("TER 23", "12:30")  )
            test.add(mockTest("TER 23", "13:00")  )
            test.add(mockTest("TER 23", "15:30")  )
            test.add(mockTest("TER 23", "20:30")  )

        return test
    }

    private fun mockTest(section: String, hour: String) =
        Test(
            section = section,
            hour = hour,
            typeService = "CFTV",
            codeOfType = "#GX22LLV9"
        )
}