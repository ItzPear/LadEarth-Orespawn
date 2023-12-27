/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.Teleporter;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OreSpawnTeleporter
/*     */   extends Teleporter
/*     */ {
/*     */   private WorldServer world;
/*     */   private World oldWorld;
/*     */   private Random random;
/*     */   private int newdim;
/*     */   
/*     */   public OreSpawnTeleporter(WorldServer par1WorldServer, int dim, World par2World) {
/*  35 */     super(par1WorldServer);
/*  36 */     this.world = par1WorldServer;
/*  37 */     this.oldWorld = par2World;
/*  38 */     this.random = new Random(par1WorldServer.getSeed());
/*  39 */     this.newdim = dim;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
/*  46 */     justPutMe(par1Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
/*  53 */     justPutMe(par1Entity);
/*  54 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean makePortal(Entity par1Entity) {
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isGroundBlock(Block bid) {
/*  65 */     if (bid == Blocks.air) return false; 
/*  66 */     if (bid == Blocks.dirt) return true; 
/*  67 */     if (bid == Blocks.grass) return true; 
/*  68 */     if (bid == Blocks.stone) return true; 
/*  69 */     if (bid == Blocks.end_stone) return true; 
/*  70 */     if (bid == Blocks.netherrack) return true; 
/*  71 */     if (bid == Blocks.cobblestone) return true; 
/*  72 */     if (bid == Blocks.sand) return true; 
/*  73 */     if (bid == Blocks.sandstone) return true; 
/*  74 */     if (bid == Blocks.farmland) return true; 
/*  75 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean justPutMe(Entity par1Entity) {
/*  83 */     int posX = (int)par1Entity.posX;
/*  84 */     int posZ = (int)par1Entity.posZ;
/*  85 */     int posY = 120;
/*  86 */     int found = 0;
/*     */     
/*  88 */     int inarow = 0;
/*  89 */     int airfound = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     for (int i = 0; i < 1000 && found == 0; i++) {
/*     */ 
/*     */       
/*  98 */       for (posY = 180; posY > 1; posY--) {
/*     */ 
/*     */         
/* 101 */         Block bid = this.world.getBlock(posX, posY + 1, posZ);
/*     */         
/* 103 */         if (bid == Blocks.air || bid == null) {
/*     */           
/* 105 */           inarow = 0;
/* 106 */           bid = this.world.getBlock(posX, posY, posZ);
/*     */           
/* 108 */           if (bid == Blocks.air || bid == null) {
/*     */             
/* 110 */             airfound = 1;
/* 111 */             bid = this.world.getBlock(posX, posY - 1, posZ);
/*     */             
/* 113 */             if (bid != Blocks.air && bid != null) {
/*     */               
/* 115 */               if (this.world.getBlock(posX, posY - 1, posZ).getMaterial().isSolid()) {
/*     */ 
/*     */                 
/* 118 */                 found = 1;
/*     */                 
/*     */                 break;
/*     */               } 
/* 122 */               if (bid == Blocks.tallgrass && this.world.getBlock(posX, posY - 2, posZ).getMaterial().isSolid()) {
/*     */ 
/*     */                 
/* 125 */                 found = 1;
/* 126 */                 posY--;
/*     */               } 
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } else {
/* 133 */           if (isGroundBlock(bid)) inarow++; 
/* 134 */           if (airfound != 0 && inarow >= 3)
/*     */             break; 
/*     */         } 
/* 137 */       }  if (found == 0) {
/*     */         
/* 139 */         posX = (int)par1Entity.posX + this.world.rand.nextInt(3 + i / 5) - this.world.rand.nextInt(3 + i / 5);
/* 140 */         if (i > 100) posX = posX + OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5) - OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5); 
/* 141 */         if (i > 500) posX = posX + this.random.nextInt(2 + i / 5) - this.random.nextInt(2 + i / 5); 
/* 142 */         posZ = (int)par1Entity.posZ + this.world.rand.nextInt(3 + i / 5) - this.world.rand.nextInt(3 + i / 5);
/* 143 */         if (i > 100) posZ = posZ + OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5) - OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5); 
/* 144 */         if (i > 500) posZ = posZ + this.random.nextInt(2 + i / 5) - this.random.nextInt(2 + i / 5);
/*     */         
/* 146 */         airfound = 0;
/* 147 */         inarow = 0;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 153 */     if (found == 0) {
/*     */       
/* 155 */       posX = (int)par1Entity.posX;
/* 156 */       posZ = (int)par1Entity.posZ;
/* 157 */       for (posY = 180; posY > 1; posY--) {
/*     */ 
/*     */         
/* 160 */         if (Blocks.air == this.world.getBlock(posX, posY + 1, posZ) && Blocks.air == this.world.getBlock(posX, posY, posZ))
/*     */         {
/* 162 */           if (Blocks.air != this.world.getBlock(posX, posY - 1, posZ)) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 171 */     double oldX = par1Entity.posX;
/* 172 */     double oldY = par1Entity.posY;
/* 173 */     double oldZ = par1Entity.posZ;
/* 174 */     double newX = posX;
/* 175 */     double newZ = posZ;
/* 176 */     double newY = posY;
/* 177 */     if (newX < 0.0D) {
/* 178 */       newX -= 0.5D;
/*     */     } else {
/* 180 */       newX += 0.5D;
/* 181 */     }  if (newZ < 0.0D) {
/* 182 */       newZ -= 0.5D;
/*     */     } else {
/* 184 */       newZ += 0.5D;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     par1Entity.setLocationAndAngles(newX, newY, newZ, par1Entity.rotationYaw, 0.0F);
/* 200 */     par1Entity.motionX = par1Entity.motionY = par1Entity.motionZ = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 206 */     MinecraftServer minecraftserver = MinecraftServer.getServer();
/* 207 */     WorldServer worldserver = minecraftserver.worldServerForDimension(this.oldWorld.provider.dimensionId);
/* 208 */     WorldServer worldserver1 = minecraftserver.worldServerForDimension(this.newdim);
/*     */     
/* 210 */     if (par1Entity instanceof EntityPlayer) {
/* 211 */       EntityPlayer ep = (EntityPlayer)par1Entity;
/* 212 */       AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(oldX - 24.0D, oldY - 12.0D, oldZ - 24.0D, oldX + 24.0D, oldY + 12.0D, oldZ + 24.0D);
/* 213 */       List var5 = this.oldWorld.getEntitiesWithinAABB(EntityTameable.class, bb);
/* 214 */       Iterator<Entity> var2 = var5.iterator();
/*     */       
/* 216 */       while (var2.hasNext()) {
/*     */         
/* 218 */         Entity var3 = var2.next();
/* 219 */         EntityTameable et = (EntityTameable)var3;
/*     */         
/* 221 */         if (!et.isSitting()) {
/*     */ 
/*     */ 
/*     */           
/* 225 */           String p1 = ep.getUniqueID().toString();
/* 226 */           String p2 = et.func_152113_b();
/* 227 */           if ((p1 != null && p2 != null && p1.equals(p2)) || et.isOwner((EntityLivingBase)ep)) {
/* 228 */             sendToThisDimension(var3, newX, newY, newZ, (int)ep.rotationYaw);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     worldserver.resetUpdateEntityTick();
/* 239 */     worldserver1.resetUpdateEntityTick();
/* 240 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendToThisDimension(Entity e, double newX, double newY, double newZ, int ro) {
/* 245 */     if (this.oldWorld.isRemote) {
/*     */       return;
/*     */     }
/* 248 */     e.worldObj.removeEntity(e);
/* 249 */     e.isDead = false;
/* 250 */     e.setLocationAndAngles(newX, newY, newZ, ro, 0.0F);
/* 251 */     e.motionX = e.motionY = e.motionZ = 0.0D;
/* 252 */     e.setWorld((World)this.world);
/* 253 */     Entity var6 = EntityList.createEntityByName(EntityList.getEntityString(e), (World)this.world);
/* 254 */     if (var6 != null) {
/*     */       
/* 256 */       var6.copyDataFrom(e, true);
/* 257 */       var6.setLocationAndAngles(newX, newY, newZ, ro, 0.0F);
/* 258 */       var6.motionX = var6.motionY = var6.motionZ = 0.0D;
/* 259 */       var6.setWorld((World)this.world);
/* 260 */       this.world.spawnEntityInWorld(var6);
/*     */     } 
/*     */     
/* 263 */     e.isDead = true;
/*     */   }
/*     */   
/*     */   public void removeStalePortalLocations(long par1) {}
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreSpawnTeleporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */