VERSION 5.00
Begin VB.Form frmSplashB 
   BackColor       =   &H00000000&
   BorderStyle     =   3  'Fixed Dialog
   ClientHeight    =   5070
   ClientLeft      =   255
   ClientTop       =   1410
   ClientWidth     =   9315
   ClipControls    =   0   'False
   ControlBox      =   0   'False
   BeginProperty Font 
      Name            =   "Chiller"
      Size            =   48
      Charset         =   0
      Weight          =   400
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
   Icon            =   "frmSplashB.frx":0000
   KeyPreview      =   -1  'True
   LinkTopic       =   "Form2"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   5070
   ScaleWidth      =   9315
   ShowInTaskbar   =   0   'False
   StartUpPosition =   2  'CenterScreen
   Begin VB.Timer tmrInitiate 
      Interval        =   1
      Left            =   8160
      Top             =   360
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "Undead Archers"
      BeginProperty Font 
         Name            =   "Chiller"
         Size            =   72
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00C0C0C0&
      Height          =   3375
      Left            =   4920
      TabIndex        =   2
      Top             =   1680
      Width           =   3615
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Loading........"
      BeginProperty Font 
         Name            =   "Parchment"
         Size            =   36
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFFF&
      Height          =   855
      Left            =   0
      TabIndex        =   1
      Top             =   0
      Width           =   2175
   End
   Begin VB.Shape shpLoad 
      FillColor       =   &H00FFFFFF&
      FillStyle       =   0  'Solid
      Height          =   375
      Left            =   2160
      Top             =   240
      Width           =   135
   End
   Begin VB.Label lblSubHead 
      AutoSize        =   -1  'True
      BackStyle       =   0  'Transparent
      BeginProperty Font 
         Name            =   "Script MT Bold"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFFF&
      Height          =   435
      Left            =   3000
      TabIndex        =   0
      Top             =   720
      Width           =   90
   End
   Begin VB.Image Image1 
      Height          =   4080
      Left            =   0
      Picture         =   "frmSplashB.frx":08CA
      Stretch         =   -1  'True
      Top             =   960
      Width           =   3915
   End
End
Attribute VB_Name = "frmSplashB"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
'Coded by: Shobhit and Sethuwran
Option Explicit

Private Sub Form_KeyPress(KeyAscii As Integer)
If KeyAscii <> 27 Then 'If esc key is not pressed

'Redirect to main form
    frmMainB.Show
    Unload Me
    
Else
    frmMMain.Show
    Unload Me
    
End If

End Sub



Private Sub tmrInitiate_Timer()
'Progress bar

    shpLoad.Width = shpLoad.Width + 20

 
    Select Case shpLoad.Width

    Case Is <= 1000
    
        lblSubHead.Caption = "Creating Interfaces"
    
    Case 1000 To 2000

        lblSubHead.Caption = "Making controls"
    
    Case 2000 To 3000

        lblSubHead.Caption = "Loading forms"

    Case 3000 To 4000

        lblSubHead.Caption = "Initializing program"
    
    Case Is >= 5000

        frmMainB.Show
        Unload Me

    End Select

End Sub
