class VersionCompare {

    init {
        compareVersion("1.0.0", "1.0.1")
        compareVersion("1.0.0", "1.1.0")
        compareVersion("1.0.0", "2.0.0")
        compareVersion("1.0.9", "2.0.1")
        compareVersion("1.9.0", "2.1.0")
        compareVersion("4.0.0", "3.0.0")
    }

    /**
     * v1, v2를 비교해 높은 버전을 반환합니다.
     * major.minor.hotfix 형식만 지원합니다.
     */
    private fun compareVersion(v1: String, v2: String, index: Int = 0): String {
        try {
            val code1 = v1.split(".")[index]
            val code2 = v2.split(".")[index]
            val nextIndex = index + 1
            when {
                code1 < code2 -> return v2
                code1 == code2 -> {
                    return compareVersion(v1, v2, nextIndex)
                }
                else -> return v1
            }
        } catch (e: IndexOutOfBoundsException) {
            return v1
        }
    }
}