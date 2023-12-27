/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Bee
/*     */   extends EntityMob
/*     */ {
/*  58 */   private ChunkCoordinates currentFlightTarget = null;
/*  59 */   private GenericTargetSorter TargetSorter = null;
/*  60 */   private int stuck_count = 0;
/*  61 */   private int lastX = 0;
/*  62 */   private int lastZ = 0;
/*  63 */   private Entity rt = null;
/*     */   
/*     */   public Bee(World par1World) {
/*  66 */     super(par1World);
/*  67 */     setSize(1.5F, 2.5F);
/*  68 */     getNavigator().setAvoidsWater(false);
/*  69 */     this.experienceValue = 25;
/*  70 */     this.isImmuneToFire = false;
/*  71 */     this.fireResistance = 5;
/*  72 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  78 */     super.applyEntityAttributes();
/*  79 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  80 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3199999928474426D);
/*     */     
/*  82 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Bee_stats.attack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  88 */     super.entityInit();
/*  89 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  93 */     if (isNoDespawnRequired()) return false; 
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/*  99 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 104 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 111 */     return 0.25F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 118 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 125 */     return "orespawn:Beebuzz";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 132 */     return "orespawn:dragonfly_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 139 */     return "orespawn:alo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 153 */     return OreSpawnMain.Bee_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 161 */     return Item.getItemFromBlock((Block)Blocks.yellow_flower);
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 166 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*     */     
/* 168 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 175 */     int var4 = 2 + this.worldObj.rand.nextInt(10); int i;
/* 176 */     for (i = 0; i < var4; i++) {
/* 177 */       dropItemRand(Items.gold_nugget, 1);
/*     */     }
/* 179 */     var4 = 2 + this.worldObj.rand.nextInt(10);
/* 180 */     for (i = 0; i < var4; i++) {
/* 181 */       dropItemRand(OreSpawnMain.MyButterCandy, 1);
/*     */     }
/* 183 */     var4 = 2 + this.worldObj.rand.nextInt(10);
/* 184 */     for (i = 0; i < var4; i++) {
/* 185 */       dropItemRand(Item.getItemFromBlock((Block)Blocks.yellow_flower), 1);
/*     */     }
/* 187 */     var4 = 2 + this.worldObj.rand.nextInt(10);
/* 188 */     for (i = 0; i < var4; i++) {
/* 189 */       dropItemRand(Items.sugar, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 198 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 206 */     super.onUpdate();
/*     */     
/* 208 */     this.motionY *= 0.6D;
/* 209 */     if (isInWater() && this.worldObj.rand.nextInt(4) == 1) {
/* 210 */       attackEntityAsMob((Entity)this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 219 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), OreSpawnMain.Bee_stats.attack);
/* 220 */     if (this.worldObj.rand.nextInt(3) == 1 && par1Entity != null) {
/* 221 */       ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, 50, 0));
/*     */     }
/* 223 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 231 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 237 */     int xdir = 1;
/* 238 */     int zdir = 1;
/*     */     
/* 240 */     int keep_trying = 50;
/*     */ 
/*     */ 
/*     */     
/* 244 */     if (this.isDead)
/* 245 */       return;  super.updateAITasks();
/*     */     
/* 247 */     if (this.lastX == (int)this.posX && this.lastZ == (int)this.posZ) {
/*     */       
/* 249 */       this.stuck_count++;
/*     */     } else {
/* 251 */       this.stuck_count = 0;
/* 252 */       this.lastX = (int)this.posX;
/* 253 */       this.lastZ = (int)this.posZ;
/*     */     } 
/*     */ 
/*     */     
/* 257 */     if (this.currentFlightTarget == null) {
/* 258 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */ 
/*     */     
/* 262 */     if (this.stuck_count > 50 || this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 264 */       Block bid = Blocks.stone;
/* 265 */       this.stuck_count = 0;
/* 266 */       while (bid != Blocks.air && keep_trying != 0) {
/* 267 */         zdir = this.rand.nextInt(9) + 4;
/* 268 */         xdir = this.rand.nextInt(9) + 4;
/* 269 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 270 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 271 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(6) - 3, (int)this.posZ + zdir);
/* 272 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 273 */         if (bid == Blocks.air && 
/* 274 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 275 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 278 */         keep_trying--;
/*     */       }
/*     */     
/* 281 */     } else if (this.rand.nextInt(15) == 0) {
/*     */ 
/*     */       
/* 284 */       EntityLivingBase e = null;
/* 285 */       e = (EntityLivingBase)this.rt;
/* 286 */       if (e != null && 
/* 287 */         e.isDead) e = null;
/*     */       
/* 289 */       if (e == null) {
/* 290 */         e = findSomethingToAttack();
/*     */       }
/* 292 */       if (e != null) {
/*     */ 
/*     */         
/* 295 */         setAttacking(1);
/* 296 */         this.currentFlightTarget.set((int)e.posX, (int)e.posY + 1, (int)e.posZ);
/* 297 */         if (getDistanceSqToEntity((Entity)e) < 16.0D) {
/* 298 */           attackEntityAsMob((Entity)e);
/*     */         }
/*     */       } else {
/* 301 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */     
/* 305 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 306 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 307 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 308 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30000000149011613D;
/* 309 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 310 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30000000149011613D;
/* 311 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 312 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 313 */     this.moveForward = 1.0F;
/* 314 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
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
/*     */   protected boolean canTriggerWalking() {
/* 329 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 347 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 357 */     boolean ret = super.attackEntityFrom(par1DamageSource, par2);
/* 358 */     Entity e = par1DamageSource.getEntity();
/* 359 */     if (e != null && e instanceof EntityLivingBase && this.currentFlightTarget != null) {
/*     */       
/* 361 */       this.rt = e;
/* 362 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */     } 
/* 364 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 376 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) return true;  int k;
/* 377 */     for (k = -2; k < 2; k++) {
/*     */       
/* 379 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 381 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 383 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 384 */           if (bid == Blocks.mob_spawner) {
/* 385 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 386 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 387 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 388 */             if (s != null && 
/* 389 */               s.equals("Bee")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 395 */     for (k = -1; k < 2; k++) {
/*     */       
/* 397 */       for (int j = -1; j < 2; j++) {
/*     */         
/* 399 */         for (int i = 1; i < 5; i++) {
/*     */           
/* 401 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 402 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 406 */     if (this.posY < 50.0D) return false; 
/* 407 */     if (!this.worldObj.isDaytime()) return false; 
/* 408 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 416 */     return OreSpawnMain.Bee_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 432 */     if (par1EntityLiving == null)
/*     */     {
/* 434 */       return false;
/*     */     }
/* 436 */     if (par1EntityLiving == this)
/*     */     {
/* 438 */       return false;
/*     */     }
/* 440 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 443 */       return false;
/*     */     }
/* 445 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 448 */       return false;
/*     */     }
/* 450 */     if (par1EntityLiving.isInWater())
/*     */     {
/* 452 */       return false;
/*     */     }
/* 454 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 456 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 457 */       if (p.capabilities.isCreativeMode == true) {
/* 458 */         return false;
/*     */       }
/* 460 */       return true;
/*     */     } 
/* 462 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntityVillager)
/*     */     {
/* 464 */       return true;
/*     */     }
/* 466 */     if (par1EntityLiving instanceof Girlfriend)
/*     */     {
/* 468 */       return true;
/*     */     }
/* 470 */     if (par1EntityLiving instanceof Boyfriend)
/*     */     {
/* 472 */       return true;
/*     */     }
/*     */     
/* 475 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 480 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 481 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0D, 6.0D, 10.0D));
/* 482 */     Collections.sort(var5, this.TargetSorter);
/* 483 */     Iterator<?> var2 = var5.iterator();
/* 484 */     Entity var3 = null;
/* 485 */     EntityLivingBase var4 = null;
/*     */     
/* 487 */     while (var2.hasNext()) {
/*     */       
/* 489 */       var3 = (Entity)var2.next();
/* 490 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 492 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 494 */         return var4;
/*     */       }
/*     */     } 
/* 497 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Bee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */