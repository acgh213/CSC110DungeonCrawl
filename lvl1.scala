import fang2.sprites._
import fang2.core.Game
import fang2.core.Sound
import java.awt.Color


class lvl1 extends Game(900,800) {
case class Enemy(name: String, str: Int, spd: Int, hp: Int, armor: Int, xp: Int)
 var playerChar = new ImageSprite("you.png")
 val largeDoor = new ImageSprite("tempDoor.png")
 val door1 = new ImageSprite("door.png")
 val door2 = new ImageSprite("door.png")
 val door3 = new ImageSprite("door.png")
 val doorLst : List[ImageSprite] = List.tabulate(12)(door => new ImageSprite("door.png"))
 val hall1l: List[ImageSprite] =  List.tabulate(10)(h1l => new ImageSprite("WoodFloor.png"))
 val hall1r: List[ImageSprite] = List.tabulate(10)(h1r => new ImageSprite("WoodFloor.png"))
 val hall2l: List[ImageSprite] = List.tabulate(30)(h2l => new ImageSprite("WoodFloor.png"))
 val hall2r: List[ImageSprite] = List.tabulate(30)(h2r => new ImageSprite("WoodFloor.png"))
 val hall3l: List[ImageSprite] = List.tabulate(15)(h3l => new ImageSprite("WoodFloor.png"))
 val hall3r: List[ImageSprite] = List.tabulate(15)(h3r => new ImageSprite("WoodFloor.png"))
 val hall3l2: List[ImageSprite] = List.tabulate(15)(h3l2 => new ImageSprite("WoodFloor.png"))
 val hall3r2: List[ImageSprite] = List.tabulate(15)(h3r2 => new ImageSprite("WoodFloor.png"))
 val hall3t: List[ImageSprite] = List.tabulate(6)(h3t => new ImageSprite("WoodFloor.png"))
 val hall3b: List[ImageSprite] = List.tabulate(6)(h3b => new ImageSprite("WoodFloor.png"))
 val room1l: List[ImageSprite] = List.tabulate(4)(rm1l => new ImageSprite("WoodFloor.png"))
 val room1r: List[ImageSprite] = List.tabulate(4)(rm1r => new ImageSprite("WoodFloor.png"))
 val room2l: List[ImageSprite] = List.tabulate(4)(rm2l => new ImageSprite("WoodFloor.png"))
 val room2r: List[ImageSprite] = List.tabulate(4)(rm2r => new ImageSprite("WoodFloor.png"))
 val room3l: List[ImageSprite] = List.tabulate(4)(rm3l => new ImageSprite("WoodFloor.png"))
 val room3r: List[ImageSprite] = List.tabulate(4)(rm3r => new ImageSprite("WoodFloor.png"))
 val room4l: List[ImageSprite] = List.tabulate(3)(rm4l => new ImageSprite("WoodFloor.png"))
 val room4r: List[ImageSprite] = List.tabulate(3)(rm4r => new ImageSprite("WoodFloor.png"))
 val room5t: List[ImageSprite] = List.tabulate(6)(rm5t => new ImageSprite("WoodFloor.png"))
 val room5b: List[ImageSprite] = List.tabulate(6)(rm5b => new ImageSprite("WoodFloor.png"))
 val room6t: List[ImageSprite] = List.tabulate(6)(rm6t => new ImageSprite("WoodFloor.png"))
 val room6ct: List[ImageSprite] = List.tabulate(6)(rm6ct => new ImageSprite("WoodFloor.png"))
 val room6cb: List[ImageSprite] = List.tabulate(6)(rm6cb => new ImageSprite("WoodFloor.png"))
 val room6b: List[ImageSprite] = List.tabulate(6)(rm6b => new ImageSprite("WoodFloor.png"))
 val room7t: List[ImageSprite] = List.tabulate(12)(rm7t => new ImageSprite("WoodFloor.png"))
 val room7ct: List[ImageSprite] = List.tabulate(12)(rm7ct => new ImageSprite("WoodFloor.png"))
 val room7cb: List[ImageSprite] = List.tabulate(12)(rm7cb => new ImageSprite("WoodFloor.png"))
 val room7b: List[ImageSprite] = List.tabulate(12)(rm7b => new ImageSprite("WoodFloor.png"))
 val ratLst : List[ImageSprite] = List.tabulate(5)(rat => new ImageSprite("Rat.png"))
 val gobLst : List[ImageSprite] = List.tabulate(1)(gob => new ImageSprite("Goblin.png"))
 val slimeLst : List[ImageSprite] = List.tabulate(2)(slime => new ImageSprite("Slime.png"))
 val skelLst : List[ImageSprite] = List.tabulate(2)(skel => new ImageSprite("Skeleton.png"))
 val enemyNames : Array[String] = Array("Skeleton","Rat","Rats","Goblin","Slime")
 val healthBars : List[StringSprite] = List.tabulate(4)(hBar => new StringSprite("name"))
 val playerStartPos = (0.05,0.875)
 val playerSpd = 0.00625
 var playerStr = 6
 var playerSpeed = 1
 var playerLvl = 1
 var youHp = 20
 var youArmor = 0
 var curXp = 0
 var xpNeeded = 20*(playerLvl*playerLvl)
 var skel1 = Enemy(enemyNames(0),4,4,15,1,10)
 var skel1dmg = 0
 var skel1xpGiven = false
 var rat1 = Enemy(enemyNames(1),2,8,10,0,5)
 var rat1dmg = 0
 var rat1xpGiven = false
 var rat2 = Enemy(enemyNames(2),2,6,10,0,5)
 var rat2dmg = 0
 var rat2xpGiven = false
 var rat3 = Enemy(enemyNames(2),4,8,10,0,5)
 var rat3dmg = 0
 var rat3xpGiven = false
 var attacking = false
 var swinging = false
 var swingTime = 0
 

 
 
 override def setup {
   
   for(h1l<- hall1l.indices) {
     hall1l(h1l).setScale(0.025)
     addSprite(hall1l(h1l))
   }
     for(h1r <- hall1r.indices) {
     hall1r(h1r).setScale(0.025)
     addSprite(hall1r(h1r))
   }
   for(h2l<- hall2l.indices) {
     hall2l(h2l).setScale(0.025)
     addSprite(hall2l(h2l))
   }
   for(h2r <- hall2r.indices) {
       hall2r(h2r).setScale(0.025)
     addSprite(hall2r(h2r))
   }
    for(h3l<- hall3l.indices) {
     hall3l(h3l).setScale(0.025)
     addSprite(hall3l(h3l))
   }
     for(h3r <- hall3r.indices) {
       hall3r(h3r).setScale(0.025)
     addSprite(hall3r(h3r))
   }
    for(h3l2<- hall3l2.indices) {
     hall3l2(h3l2).setScale(0.025)
     addSprite(hall3l2(h3l2))
   }
     for(h3r2 <- hall3r2.indices) {
       hall3r2(h3r2).setScale(0.025)
     addSprite(hall3r2(h3r2))
   }
   for(h3t <- hall3t.indices) {
       hall3t(h3t).setScale(0.025)
     addSprite(hall3t(h3t))
   }
   for(h3b <- hall3b.indices) {
       hall3b(h3b).setScale(0.025)
     addSprite(hall3b(h3b))
   }
   for(rm1l<- room1l.indices) {
     room1l(rm1l).setScale(0.025)
     addSprite(room1l(rm1l))
   }
     for(rm1r <- room1r.indices) {
       room1r(rm1r).setScale(0.025)
     addSprite(room1r(rm1r))
   }
    for(rm2l<- room2l.indices) {
     room2l(rm2l).setScale(0.025)
     addSprite(room2l(rm2l))
   }
     for(rm2r <- room2r.indices) {
       room2r(rm2r).setScale(0.025)
     addSprite(room2r(rm2r))
   }
   for(rm3l<- room3l.indices) {
     room3l(rm3l).setScale(0.025)
     addSprite(room3l(rm3l))
   }
     for(rm3r <- room3r.indices) {
       room3r(rm3r).setScale(0.025)
     addSprite(room3r(rm3r))
   }
     for(rm4l<- room4l.indices) {
     room4l(rm4l).setScale(0.025)
     addSprite(room4l(rm4l))
   }
     for(rm4r <- room4r.indices) {
       room4r(rm4r).setScale(0.025)
     addSprite(room4r(rm4r))
   }
      for(rm5t<- room5t.indices) {
     room5t(rm5t).setScale(0.025)
     addSprite(room5t(rm5t))
   }
     for(rm5b <- room5b.indices) {
       room5b(rm5b).setScale(0.025)
     addSprite(room5b(rm5b))
   }
      for(rm6t<- room6t.indices) {
     room6t(rm6t).setScale(0.025)
     addSprite(room6t(rm6t))
   }
      for(rm6ct<- room6ct.indices) {
     room6ct(rm6ct).setScale(0.025)
     addSprite(room6ct(rm6ct))
   }
     for(rm6cb <- room6cb.indices) {
       room6cb(rm6cb).setScale(0.025)
     addSprite(room6cb(rm6cb))
   }
     for(rm6b <- room6b.indices) {
       room6b(rm6b).setScale(0.025)
     addSprite(room6b(rm6b))
   }
     for(rm7t<- room7t.indices) {
     room7t(rm7t).setScale(0.025)
     addSprite(room7t(rm7t))
   }
      for(rm7ct<- room7ct.indices) {
     room7ct(rm7ct).setScale(0.025)
     addSprite(room7ct(rm7ct))
   }
     for(rm7cb <- room7cb.indices) {
       room7cb(rm7cb).setScale(0.025)
     addSprite(room7cb(rm7cb))
   }
     for(rm7b <- room7b.indices) {
       room7b(rm7b).setScale(0.025)
     addSprite(room7b(rm7b))
   }
   
   for(hBar <- healthBars.indices) {
     healthBars(hBar).setScale(0.035)
     healthBars(hBar).setColor(Color.GREEN)
 }
      for(rat <- ratLst.indices) {
   ratLst(rat).setScale(0.025)
   addSprite(ratLst(rat))
      }
      for(gob <- gobLst.indices) {
   gobLst(gob).setScale(0.03)
   addSprite(gobLst(gob))
      }
       for(slime <- slimeLst.indices) {
   slimeLst(slime).setScale(0.03)
   addSprite(slimeLst(slime))
      }
      for(skel <- skelLst.indices) {
   skelLst(skel).setScale(0.03)
   
      }
      
      for(door <- doorLst.indices) {
        doorLst(door).setScale(0.035)
        addSprite(doorLst(door))
        doorLst(0).setRotationDegrees(90)
        doorLst(7).setRotationDegrees(270)
        doorLst(8).setRotationDegrees(270)
        doorLst(1).setRotationDegrees(180)
        doorLst(3).setRotationDegrees(180)
        doorLst(5).setRotationDegrees(180)
      }
      
      playerChar.setLocation(playerStartPos._1, playerStartPos._2)
      playerChar.setScale(0.035)
     addSprite(playerChar)

}
 override def advance {
   
   for(door <-doorLst.indices){
   if(playerChar.intersects(doorLst(door)))
   handleDraw
    }
    
    def handleDraw {
      if(playerChar.intersects(doorLst(0)))
        hall2(0.05,0.725)
      else if(playerChar.intersects(doorLst(1)))
        room1(0.275,0.75)
      else if(playerChar.intersects(doorLst(2)))
          hall3(0.025,0.9)
      else if(playerChar.intersects(doorLst(3)))
        room2(0.475,0.75)
      else if(playerChar.intersects(doorLst(4)))
        room4(0.675,0.65)
      else if(playerChar.intersects(doorLst(5)))
        room3(0.675,0.75)
      else if(playerChar.intersects(doorLst(6)))
        room7(0.495,0.275)
      else if(playerChar.intersects(doorLst(7)))
        room5(0.325,0.47)
      else if(playerChar.intersects(doorLst(8)))
        room6(0.325,0.56)
    }
   
   def hall1 (x: Double, y: Double) {
   for(h1l <- hall1l.indices) {
     var setHall1l = hall1l(h1l).setLocation(x+0.025,y-0.025*h1l)
   }
   
   for (h1r <- hall1r.indices) {
     var setHall1r = hall1r(h1r).setLocation(x+0.05,y-0.025*h1r)
   }
   for(door <-doorLst.indices){
   var Door1set = doorLst(0).setLocation(x+0.075,y-0.175)
   }
   for(hBar <- healthBars.indices) {
     addSprite(healthBars(0))
     val hBar1Set = healthBars(0).setLocation(x+0.05,y-0.25)
     healthBars(0).setText(enemyNames(0))
     if (skel1.hp <= 0)
      healthBars(0).setLocation(-1,-1)
     }
   if(skel1xpGiven == false)
   for(skel <- skelLst) {
     addSprite(skelLst(0))
     val skel1Set = skelLst(0).setLocation(x+0.05,y-0.225)
     if ((playerChar.intersects(skelLst(0)))&&(swinging == false))
       attackSkel1
   }
 }
   
     
   
   
   def hall2 (x:Double , y:Double) {
     
     for(h2l <- hall2l.indices) {
     var setHall2l = hall2l(h2l).setLocation(x+0.025*h2l,y)
   }
   for (h2r <- hall2r.indices) {
     var setHall2r = hall2r(h2r).setLocation(x+0.025*h2r,y+0.025)
   }
   for(door <- doorLst.indices) {
     
     var Door2 = doorLst(1).setLocation(x+0.2375,y+0.055)
     var Door3 = doorLst(2).setLocation(x+0.4375,y-0.025)
     var Door4 = doorLst(3).setLocation(x+0.4375,y+0.055)
     var Door5 = doorLst(4).setLocation(x+0.6375,y-0.025)
     var Door6 = doorLst(5).setLocation(x+0.6375,y+0.055)
   }
   }
   def room1 (x:Double, y:Double) {
     for(rm1l <- room1l.indices) {
     var setRoom1l = room1l(rm1l).setLocation(x,y+0.025*rm1l)
   }
   for (rm1r <- room1r.indices) {
     var setRoom1r = room1r(rm1r).setLocation(x+0.025,y+0.025*rm1r)
   }
    for(hBar <- healthBars.indices) {
     addSprite(healthBars(1))
     val hBar1Set = healthBars(1).setLocation(x+0.01,y+0.075)
     healthBars(1).setText(enemyNames(1))
   }
   if(rat1xpGiven == false){
   for (rat <- ratLst.indices) {
      var rat1Set = ratLst(0).setLocation(x+0.01,y+0.05)
      if (playerChar.intersects(ratLst(0)))
       attackRat1 
}
   }
   }
    def room2 (x:Double, y:Double) {
     for(rm2l <- room2l.indices) {
     var setRoom2l = room2l(rm2l).setLocation(x,y+0.025*rm2l)
   }
   for (rm2r <- room2r.indices) {
     var setRoom2r = room2r(rm2r).setLocation(x+0.025,y+0.025*rm2r)
   }
    for(hBar <- healthBars.indices) {
     addSprite(healthBars(2))
     val hBar2Set = healthBars(2).setLocation(x-0.005,y+0.115)
     healthBars(2).setText(enemyNames(2))
     addSprite(healthBars(3))
     val hBar3Set = healthBars(3).setLocation(x+0.02,y+0.115)
     healthBars(3).setText(enemyNames(2))
     

   }
   if(rat2xpGiven == false){
   for (rat <- ratLst.indices) {
      var rat2Set = ratLst(1).setLocation(x+0.01,y+0.05)
      if (playerChar.intersects(ratLst(1)))
       attackRat2 
   }
    }
    if(rat3xpGiven == false){   
      for (rat <- ratLst.indices) {
      var rat3Set = ratLst(2).setLocation(x+0.02,y+0.075)
      if (playerChar.intersects(ratLst(2)))
       attackRat3
    }
    }
    }
    def room3 (x:Double, y:Double) {
     for(rm3l <- room3l.indices) {
     var setRoom3l = room3l(rm3l).setLocation(x,y+0.025*rm3l)
   }
   for (rm3r <- room3r.indices) {
     var setRoom3r = room3r(rm3r).setLocation(x+0.025,y+0.025*rm3r)
   }
   for (gob <- gobLst.indices) {
      var gob1Set = gobLst(0).setLocation(x+0.01,y+0.05)
   }
   }
    def room4 (x:Double, y:Double) {
     for(rm4l <- room4l.indices) {
     var setRoom4l = room4l(rm4l).setLocation(x,y+0.025*rm4l)
   }
   for (rm4r <- room4r.indices) {
     var setRoom4r = room4r(rm4r).setLocation(x+0.025,y+0.025*rm4r)
   }
    for (slime <- slimeLst.indices) {
      var slime1Set = slimeLst(0).setLocation(x+0.01,y)
   }
   }
    def room5 (x:Double, y:Double) {
     for(rm5t <- room5t.indices) {
     var setRoom5t = room5t(rm5t).setLocation(x+0.025*rm5t,y)
   }
   for (rm5b <- room5b.indices) {
     var setRoom5b = room5b(rm5b).setLocation(x+0.025*rm5b,y+0.025)
   }
   }
    def room6 (x:Double, y:Double) {
     for(rm6t <- room6t.indices) {
     var setRoom6t = room6t(rm6t).setLocation(x+0.025*rm6t,y)
   }
     for(rm6ct <- room6ct.indices) {
     var setRoom6ct = room6ct(rm6ct).setLocation(x+0.025*rm6ct,y+0.025)
   }
   for (rm6cb <- room6cb.indices) {
     var setRoom6cb = room6cb(rm6cb).setLocation(x+0.025*rm6cb,y+0.05)
   }
   for (rm6b <- room6b.indices) {
     var setRoom6b = room6b(rm6b).setLocation(x+0.025*rm6b,y+0.075)
   }
   }
   def room7 (x: Double, y:Double) {
     for(rm7t <- room7t.indices) {
     var setRoom7t = room7t(rm7t).setLocation(x-0.025*rm7t,y)
   }
     for(rm7ct <- room7ct.indices) {
     var setRoom7ct = room7ct(rm7ct).setLocation(x-0.025*rm7ct,y+0.025)
   }
   for (rm7cb <- room7cb.indices) {
     var setRoom7cb = room7cb(rm7cb).setLocation(x-0.025*rm7cb,y+0.05)
   }
   for (rm7b <- room7b.indices) {
     var setRoom7b = room7b(rm7b).setLocation(x-0.025*rm7b,y+0.075)
   }
   }
   def hall3 (x:Double, y:Double) {
     for(door <- doorLst.indices) {
     var Door7 = doorLst(6).setLocation(x+0.45,y-0.530)
     var Door8 = doorLst(7).setLocation(x+0.42,y-0.425)
     var Door9 = doorLst(8).setLocation(x+0.42,y-0.325)
     }
    for(h3l2 <- hall3l2.indices) {
     var setHall3l2 = hall3l2(h3l2).setLocation(0.425+x+0.025,y-0.025*h3l2-0.15)
   }
   for (h3r2 <- hall3r2.indices) {
     var setHall3r2 = hall3r2(h3r2).setLocation(0.4225+x+0.05,y-0.025*h3r2-0.15)
   }
      for(h3t <- hall3t.indices) {
     var setHall3t = hall3t(h3t).setLocation(0.325+x*h3t,0.025+y-0.5)
   }
   for (h3b <- hall3b.indices) {
     var setHall3b = hall3b(h3b).setLocation(0.325+x*h3b,y-0.5)
   }
   var setDoors = { door2.setLocation(0.335+x,y-0.13)
   door3.setLocation(x, y)
   }
   }
 def buildPath {
  hall1(0.025,0.9)
  hall2(0.05,0.725)
  hall3(0.025,0.9)
  room1(0.275,0.75)
  room2(0.475,0.75)
  room3(0.675,0.75)
  room4(0.675,0.65)
  room5(0.325,0.47)
  room6(0.325,0.56)
  room7(0.4,0.625)
}
def attackSkel1 {
  
  if (swinging == false && playerChar.intersects(skelLst(0))){
    doDmg
    changeColor
  }
}
    def changeColor {
    for(hBars <- healthBars.indices) 
     if (skel1dmg >= 5 && skel1dmg < 10){
    healthBars(0).setColor(Color.YELLOW)}
       else if (skel1dmg < 15 && skel1dmg >= 10){
      healthBars(0).setColor(Color.RED)}
      else if (skel1dmg >= 15){
      healthBars(0).setColor(Color.WHITE)
      getXp
      }
      }
    def doDmg {
    var dmg = ((playerStr*playerSpeed)-(skel1.armor))
    skel1dmg = skel1dmg + dmg
    println("Attacking " + enemyNames(0) + ". You dealt " + dmg + " damage")
    var returndmg = (youHp-(skel1.str*skel1.spd)-(youArmor)).toInt
    println("Ouch! You got hit for " + returndmg + " damage.")
    swingTime += 6
    swing
    }
    def getXp {
    for(hBars <- healthBars.indices) {
     if (skel1dmg >= skel1.hp && skel1xpGiven == false){
      println("You got " + skel1.xp + " experience for fighting.")
      curXp = curXp + skel1.xp
      println(xpNeeded-curXp + " xp needed for next level up.")
      skel1xpGiven = true
    }
    }
    for(skel <-skelLst) {
      skelLst(0).setLocation(-1,-1)}
    }
    
  def attackRat1 {
  if (swinging == false && playerChar.intersects(ratLst(0))){
    Rat1doDmg
    swingTime = 6
    changeRat1Color
  }
}
    def changeRat1Color {
    for(hBars <- healthBars.indices) 
     if (rat1dmg >= 2 && rat1dmg < 5){
    healthBars(1).setColor(Color.YELLOW)}
       else if (rat1dmg < 10 && rat1dmg >= 5){
      healthBars(1).setColor(Color.RED)}
      else if (rat1dmg >= 10){
      healthBars(1).setColor(Color.WHITE)
      rat1getXp
      }
      }
    def Rat1doDmg {
    var dmg = ((playerStr*playerSpeed)-(rat1.armor))
    rat1dmg = rat1dmg + dmg
    println("Attacking " + enemyNames(1) + ". You dealt " + dmg + " damage")
    var returndmg = (youHp-(rat1.str*rat1.spd)-(youArmor)).toInt
    println("Ouch! You got hit for " + returndmg + " damage.")
    }
    def rat1getXp {
    for(hBars <- healthBars.indices) {
     if (rat1dmg >= rat1.hp && rat1xpGiven == false){
      rat1xpGiven = true
      println("You got " + rat1.xp + " experience for fighting.")
      curXp = curXp + rat1.xp
      println(xpNeeded-curXp + " xp needed for next level up.")
    }
    }
    for(rat <-ratLst) {
      ratLst(0).setLocation(-1,-1)}
    }  
      def attackRat2 {
  if (swinging == false && playerChar.intersects(ratLst(1))){
    Rat2doDmg
    swingTime = 6
    changeRat2Color
  }
}
    def changeRat2Color {
    for(hBars <- healthBars.indices) 
     if (rat2dmg >= 2 && rat2dmg < 5){
    healthBars(2).setColor(Color.YELLOW)}
       else if (rat2dmg < 10 && rat2dmg >= 5){
      healthBars(2).setColor(Color.RED)}
      else if (rat2dmg >= 10){
      healthBars(2).setColor(Color.WHITE)
      rat2getXp
      }
      }
    def Rat2doDmg {
    var dmg = ((playerStr*playerSpeed)-(rat2.armor))
    rat2dmg = rat2dmg + dmg
    println("Attacking " + enemyNames(1) + ". You dealt " + dmg + " damage")
    var returndmg = (youHp-(rat2.str*rat2.spd)-(youArmor)).toInt
    println("Ouch! You got hit for " + returndmg + " damage.")
    }
    def rat2getXp {
    for(hBars <- healthBars.indices) {
     if (rat2dmg >= rat2.hp && rat2xpGiven == false){
      rat2xpGiven = true
      println("You got " + rat2.xp + " experience for fighting.")
      curXp = curXp + rat2.xp
      println(xpNeeded-curXp + " xp needed for next level up.")
    }
    }
    for(rat <-ratLst) {
      ratLst(1).setLocation(-1,-1)}
    }    
     def attackRat3 {
  if (swinging == false && playerChar.intersects(ratLst(2))){
    Rat3doDmg
    swingTime = 6
    changeRat3Color
  }
}
    def changeRat3Color {
    for(hBars <- healthBars.indices) 
     if (rat3dmg >= 2 && rat3dmg < 5){
    healthBars(3).setColor(Color.YELLOW)}
       else if (rat3dmg < 10 && rat3dmg >= 5){
      healthBars(3).setColor(Color.RED)}
      else if (rat3dmg >= 10){
      healthBars(3).setColor(Color.WHITE)
      rat3getXp
      }
      }
    def Rat3doDmg {
    var dmg = ((playerStr*playerSpeed)-(rat3.armor))
    rat3dmg = rat3dmg + dmg
    println("Attacking " + enemyNames(1) + ". You dealt " + dmg + " damage")
    var returndmg = (youHp-(rat3.str*rat3.spd)-(youArmor)).toInt
    println("Ouch! You got hit for " + returndmg + " damage.")
    }
    def rat3getXp {
     if (rat3dmg >= rat3.hp && rat3xpGiven == false){
      rat3xpGiven = true
      println("You got " + rat3.xp + " experience for fighting.")
      curXp = curXp + rat3.xp
      println(xpNeeded-curXp + " xp needed for next level up.")
    }
    for(rat <-ratLst) {
      ratLst(2).setLocation(-1,-1)}
    }

def swing {
  if(swingTime > 0){
  swinging = true
  }
  if(swingTime <= 0){
  swinging = false}
 }

 


def moveMe {
  if (leftPressed) {
    playerChar.translateX(-playerSpd)
    swingTime -= 1
  }
   else if (upPressed) {
    playerChar.translateY(-playerSpd)
    swingTime -= 1
   }
   else if (rightPressed)  {
    playerChar.translateX(playerSpd)
    swingTime -= 1
   
   }
   else if (downPressed) {
    playerChar.translateY(playerSpd)
    swingTime -= 1
   
}
  else if (keyPressed) {
    val c = getKeyPressed
    c match {
   case i => 

}}

  }
 moveMe  
 //buildPath
 hall1(0.025,0.9) //collide with door, draw next hall/room :handleDraw
 }
}


