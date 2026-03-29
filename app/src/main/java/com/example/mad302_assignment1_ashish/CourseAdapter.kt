package com.example.mad302_assignment1_ashish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter class to manage how course data is displayed in the list.
 */
class CourseAdapter(
    private val courses: List<Course>,
    private val onItemClick: (Course) -> Unit // Click handler requirement
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    /** ViewHolder to hold the views for each list item row**/
    class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCode: TextView = view.findViewById(R.id.tvCourseCode)
        val tvName: TextView = view.findViewById(R.id.tvCourseName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.tvCode.text = course.code
        holder.tvName.text = course.name

        // Handle the tap event [cite: 5, 11]
        holder.itemView.setOnClickListener { onItemClick(course) }
    }

    override fun getItemCount() = courses.size
}