package com.example.proyectopdm2024_gt2_grupo1_tema.dbresource

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "medireminder.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS DOSIS (
                IDDOSIS INTEGER PRIMARY KEY, 
                IDRECORDATORIO INTEGER NOT NULL, 
                IDMEDICAMENTO INTEGER NOT NULL, 
                HORAADMINISTRACION TIME NOT NULL, 
                FECHAADMINISTRACION DATE NOT NULL, 
                CANTIDADDOSIS INTEGER NOT NULL, 
                ESTADO VARCHAR(15) NOT NULL, 
                FOREIGN KEY (IDMEDICAMENTO) REFERENCES MEDICAMENTOS (IDMEDICAMENTO), 
                FOREIGN KEY (IDRECORDATORIO) REFERENCES RECORDATORIOS (IDRECORDATORIO)
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS HISTORIAL (
                IDHISTORIAL INTEGER PRIMARY KEY, 
                IDPERSONA INTEGER NOT NULL, 
                IDDOSIS INTEGER NOT NULL, 
                FOREIGN KEY (IDDOSIS) REFERENCES DOSIS (IDDOSIS), 
                FOREIGN KEY (IDPERSONA) REFERENCES PERSONA (IDPERSONA)
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS MEDICAMENTOS (
                IDMEDICAMENTO INTEGER NOT NULL PRIMARY KEY, 
                CORRELATIVO INTEGER NOT NULL, 
                IDPERSONA INTEGER NOT NULL, 
                NOMBREMED VARCHAR(50) NOT NULL, 
                INSTRUCCIONES VARCHAR(256), 
                DOSIS INTEGER NOT NULL, 
                FRECUENCIA INTEGER NOT NULL, 
                FOREIGN KEY (CORRELATIVO) REFERENCES TIPOMEDICAMENTOS (CORRELATIVO), 
                FOREIGN KEY (IDPERSONA) REFERENCES PERSONA (IDPERSONA)
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS OPCIONESMENU (
                IDOPCION VARCHAR(20) NOT NULL PRIMARY KEY, 
                DESCRIPOPCION VARCHAR(1024) NOT NULL
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS PERSONA (
                IDPERSONA INTEGER NOT NULL PRIMARY KEY, 
                PRIMERNOMBRE VARCHAR(20) NOT NULL, 
                SEGUNDONOMBRE VARCHAR(20), 
                PRIMERAPELLIDO VARCHAR(20)  NOT NULL, 
                SEGUNDOAPELLIDO VARCHAR(20) , 
                FECHANACIMIENTO DATE NOT NULL
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS RECORDATORIOS (
                IDRECORDATORIO INTEGER NOT NULL PRIMARY KEY, 
                IDTIPORECORDATORIO INTEGER NOT NULL, 
                IDMEDICAMENTO INTEGER NOT NULL, 
                HORARECORD TIME NOT NULL, 
                FECHARECORD DATE NOT NULL, 
                REPETICION INTEGER, 
                FOREIGN KEY (IDTIPORECORDATORIO) REFERENCES TIPORECORDATORIOS (IDTIPORECORDATORIO), 
                FOREIGN KEY (IDMEDICAMENTO) REFERENCES MEDICAMENTOS (IDMEDICAMENTO)
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS ROLES (
                NOMBREROL VARCHAR(20) PRIMARY KEY, 
                DESCRIPROL VARCHAR(1024) NOT NULL
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS ROLES_OPCIONESMENU (
                NOMBREROL VARCHAR(20) NOT NULL, 
                IDOPCION VARCHAR(20) NOT NULL, 
                PRIMARY KEY (NOMBREROL, IDOPCION), 
                FOREIGN KEY (NOMBREROL) REFERENCES ROLES (NOMBREROL), 
                FOREIGN KEY (IDOPCION) REFERENCES OPCIONESMENU (IDOPCION)
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS SINTOMAS (
                IDSINTOMA INTEGER NOT NULL PRIMARY KEY, 
                IDPERSONA INTEGER NOT NULL, 
                DESCRIPCION VARCHAR(256) NOT NULL, 
                HORAREGISTRO TIME NOT NULL, 
                FECHAREGISTRO DATE NOT NULL, 
                FOREIGN KEY (IDPERSONA) REFERENCES PERSONA (IDPERSONA)
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS TIPOMEDICAMENTOS (
                CORRELATIVO INTEGER NOT NULL PRIMARY KEY, 
                CATEGORIAMED VARCHAR(25) NOT NULL
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS TIPORECORDATORIOS (
                IDTIPORECORDATORIO INTEGER PRIMARY KEY, 
                CATEGORIARECORD VARCHAR(25) NOT NULL
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS USUARIO (
                IDUSUARIO INTEGER NOT NULL PRIMARY KEY, 
                IDPERSONA INTEGER NOT NULL, 
                NOMBREROL VARCHAR(20) NOT NULL, 
                NOMBREUSUARIO VARCHAR(30) NOT NULL, 
                CONTRA VARCHAR(30) NOT NULL, 
                CORREOELECTRONICO VARCHAR(30) NOT NULL, 
                FOREIGN KEY (NOMBREROL) REFERENCES ROLES (NOMBREROL), 
                FOREIGN KEY (IDPERSONA) REFERENCES PERSONA (IDPERSONA)
            );
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS DOSIS")
        db.execSQL("DROP TABLE IF EXISTS HISTORIAL")
        db.execSQL("DROP TABLE IF EXISTS MEDICAMENTOS")
        db.execSQL("DROP TABLE IF EXISTS OPCIONESMENU")
        db.execSQL("DROP TABLE IF EXISTS PERSONA")
        db.execSQL("DROP TABLE IF EXISTS RECORDATORIOS")
        db.execSQL("DROP TABLE IF EXISTS ROLES")
        db.execSQL("DROP TABLE IF EXISTS ROLES_OPCIONESMENU")
        db.execSQL("DROP TABLE IF EXISTS SINTOMAS")
        db.execSQL("DROP TABLE IF EXISTS TIPOMEDICAMENTOS")
        db.execSQL("DROP TABLE IF EXISTS TIPORECORDATORIOS")
        db.execSQL("DROP TABLE IF EXISTS USUARIO")
        onCreate(db)
    }
}
