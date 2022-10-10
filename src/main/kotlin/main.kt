import java.time.LocalDateTime

data class Post(
    val id: Int,
    val content: String?,
    val authorName: String? = null,
    val authorid: Int? = null,
    val likes: Int? = null,
    val comment: Comment? = null,
    val createdByCommunity: Boolean? = null,
    val createDate: LocalDateTime? = null,
    val publishDate: LocalDateTime? = null,
    val isPinned: Boolean? = false,
)

data class Comment(
    var commentID: Int,
    var commentAuthorName: String,
    var commentContent: String,
)

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post.copy(id = getLastPostId() + 1)
        println("Post added: ${posts.last()}")
        return posts.last()
    }

    fun getLastPostId(): Int {
        return if (posts.isEmpty()) 0 else posts.last().id
    }

    fun printArray(i: Int) {
        println(posts.get(i))
    }

    fun dropPost() {
        posts = emptyArray<Post>()
    }

    fun update(post: Post): Boolean {
        var postUpdating = false
        for ((idx, currentPost) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[idx] = currentPost.copy(
                    id = post.id,
                    content = post.content,
                    authorName = post.authorName,
                    authorid = post.authorid,
                    likes = post.likes,
                    comment = post.comment,
                    createdByCommunity = post.createdByCommunity,
                    createDate = post.createDate,
                    publishDate = post.publishDate,
                    isPinned = post.isPinned
                )
                postUpdating = true
                println("Updating post with id ${post.id}: ${posts[idx]}")
            }
        }
        return postUpdating
    }
}

fun main() {
    WallService.add(Post(1, "Test content"))
    WallService.add(Post(2, "Test content1"))
    WallService.add(Post(3, "Test content2"))
    WallService.printArray(2)

    WallService.update(Post(2, "uzzzzzzzzzzz", "Vasiliy"))
}


//class WallService {
//
//    fun invoke(): Post {
//
//        var comment1 = Comment(1,"ZloyAlmaz","NONONO")
//        var post1 = Post(1,2,"Almaz","axaxa",89,comment1,false
//        ,LocalDateTime.now(),LocalDateTime.of(2022,12,10,14,5),false)
//        print(post1.toString())
//         return post1
//    }
//
//
//    private var posts = emptyArray<Post>()
//
//    fun add(post: Post): Post {
//        posts += post.copy(id = getLastPostId() + 1)
//        println("Post added: ${posts.last()}")
//        return posts.last()
//    }
//
//    }
//    fun printArray (i: Int) {
//        println(posts.get(i))
//    }
//    fun getLastPostId(): Int {
//        return if (posts.isEmpty()) 0 else posts.last().id
//    }
//
//}