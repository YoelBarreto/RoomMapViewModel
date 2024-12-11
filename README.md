# Proyecto ViewModel + Room + Mapa

Proyecto escolar en el cual en la aplicación se trata de un mapa con la capacidad de desplazarte y interactuar con marcadores almacenados en una base de datos.

## Requisitos del projecto
- Mínimo 2 tablas relacionadas entre si
- Coordenadas del mapa (de los marcadores) estén en la base de datos
- Se usa viewmodel para los marcadores
- 12 marcadores mínimo (mostrarán al menos un título)
- 4 tipos de marcadores mínimo

## Dependencias

### Room
implementation(libs.androidx.room.ktx)
implementation(libs.androidx.room.runtime)
ksp(libs.androidx.room.compiler)

### osmdroid (Mapa interactivo)
( Link del repositorio del mapa: https://github.com/osmdroid/osmdroid )

implementation(libs.osmdroid.android)
implementation(libs.osm.android.compose)
