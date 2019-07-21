package br.edu.utfpr.dv.siacoes.mobile.util

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Spinner
import br.edu.utfpr.dv.siacoes.mobile.model.*

class SpinnerUtils {

    fun loadSpinnerUser(context: Context, spinner: Spinner, list: List<User>, selected: User?) {
        var index: Int = 0
        val items: MutableList<User> = mutableListOf()

        items.addAll(list)

        if (selected != null) {
            var found: Boolean = false

            for (i in items.indices) {
                if (items[i].idUser == selected.idUser) {
                    index = i
                    found = true
                }
            }

            if (!found) {
                items.add(selected)
                index = items.size - 1
            }
        }

        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        if (selected != null) {
            spinner.setSelection(index)
        }
    }

    fun loadSpinnerCompany(context: Context, spinner: Spinner, list: List<Company>, selected: Company?) {
        var index: Int = 0
        val items: MutableList<Company> = mutableListOf()

        items.addAll(list)

        if (selected != null) {
            var found: Boolean = false

            for (i in items.indices) {
                if (items[i].idCompany == selected.idCompany) {
                    index = i
                    found = true
                }
            }

            if (!found) {
                items.add(selected)
                index = items.size - 1
            }
        }

        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        if (selected != null) {
            spinner.setSelection(index)
        }
    }

    fun loadSpinnerActivity(context: Context, spinner: Spinner, list: List<Activity>, selected: Activity?) {
        var index: Int = 0
        val items: MutableList<Activity> = mutableListOf()

        items.addAll(list)

        if (selected != null) {
            var found: Boolean = false

            for (i in items.indices) {
                if (items[i].idActivity == selected.idActivity) {
                    index = i
                    found = true
                }
            }

            if (!found) {
                items.add(selected)
                index = items.size - 1
            }
        }

        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        if (selected != null) {
            spinner.setSelection(index)
        }
    }

    fun loadSpinnerActivityGroup(context: Context, spinner: Spinner, list: List<ActivityGroup>, selected: ActivityGroup?) {
        var index: Int = 0
        val items: MutableList<ActivityGroup> = mutableListOf()

        items.addAll(list)

        if (selected != null) {
            var found: Boolean = false

            for (i in items.indices) {
                if (items[i].idActivityGroup == selected.idActivityGroup) {
                    index = i
                    found = true
                }
            }

            if (!found) {
                items.add(selected)
                index = items.size - 1
            }
        }

        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        if (selected != null) {
            spinner.setSelection(index)
        }
    }

    fun loadSpinnerCampus(context: Context, spinner: Spinner, list: List<Campus>, selected: Campus?) {
        var index: Int = 0
        val items: MutableList<Campus> = mutableListOf()

        items.addAll(list)

        if (selected != null) {
            var found: Boolean = false

            for (i in items.indices) {
                if (items[i].idCampus == selected.idCampus) {
                    index = i
                    found = true
                }
            }

            if (!found) {
                items.add(selected)
                index = items.size - 1
            }
        }

        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        if (selected != null) {
            spinner.setSelection(index)
        }
    }

    fun loadSpinnerDepartment(context: Context, spinner: Spinner, list: List<Department>, selected: Department?) {
        var index: Int = 0
        val items: MutableList<Department> = mutableListOf()

        items.addAll(list)

        if (selected != null) {
            var found: Boolean = false

            for (i in items.indices) {
                if (items[i].idDepartment == selected.idDepartment) {
                    index = i
                    found = true
                }
            }

            if (!found) {
                items.add(selected)
                index = items.size - 1
            }
        }

        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        if (selected != null) {
            spinner.setSelection(index)
        }
    }

}