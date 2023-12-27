/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ public class HerculesBeetle
/*     */   extends EntityMob
/*     */ {
/*  58 */   private GenericTargetSorter TargetSorter = null;
/*  59 */   private int hurt_timer = 0;
/*  60 */   private float moveSpeed = 0.25F;
/*     */ 
/*     */   
/*     */   public HerculesBeetle(World par1World) {
/*  64 */     super(par1World);
/*     */     
/*  66 */     setSize(3.25F, 2.75F);
/*  67 */     getNavigator().setAvoidsWater(true);
/*  68 */     this.experienceValue = 200;
/*  69 */     this.fireResistance = 100;
/*  70 */     this.isImmuneToFire = true;
/*  71 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  72 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  73 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421D, false));
/*  74 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*     */     
/*  76 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  77 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  78 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  84 */     super.entityInit();
/*  85 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  90 */     super.applyEntityAttributes();
/*  91 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  92 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  93 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.HerculesBeetle_stats.attack);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  97 */     if (isNoDespawnRequired()) return false; 
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 106 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 107 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 112 */     return OreSpawnMain.HerculesBeetle_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 121 */     return OreSpawnMain.HerculesBeetle_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 138 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 144 */     super.jump();
/* 145 */     this.motionY += 0.25D;
/* 146 */     this.posY += 0.5D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHerculesBeetleHealth() {
/* 153 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 162 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 170 */     return "orespawn:alo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 178 */     return "orespawn:hercules_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 185 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 192 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 202 */     return Items.beef;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 207 */     EntityItem var3 = null;
/* 208 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 210 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), is);
/*     */     
/* 212 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 213 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 222 */     dropItemRand(OreSpawnMain.MyBigHammer, 1);
/* 223 */     dropItemRand(Items.item_frame, 1);
/*     */     
/* 225 */     int i = 4 + this.worldObj.rand.nextInt(8); int var4;
/* 226 */     for (var4 = 0; var4 < i; var4++) {
/* 227 */       dropItemRand(Items.beef, 1);
/*     */     }
/*     */     
/* 230 */     i = 1 + this.worldObj.rand.nextInt(5);
/* 231 */     for (var4 = 0; var4 < i; var4++) {
/* 232 */       ItemStack is; int var3 = this.worldObj.rand.nextInt(20);
/* 233 */       switch (var3) {
/*     */ 
/*     */ 
/*     */         
/*     */         case 1:
/* 238 */           is = dropItemRand(Items.diamond, 1);
/*     */           break;
/*     */         case 2:
/* 241 */           is = dropItemRand(Item.getItemFromBlock(Blocks.diamond_block), 1);
/*     */           break;
/*     */         case 3:
/* 244 */           is = dropItemRand(Items.diamond_sword, 1);
/* 245 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 246 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 247 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 248 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 249 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 250 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 251 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 4:
/* 254 */           is = dropItemRand(Items.diamond_shovel, 1);
/* 255 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 256 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 5:
/* 259 */           is = dropItemRand(Items.diamond_pickaxe, 1);
/* 260 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 261 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 262 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 6:
/* 265 */           is = dropItemRand(Items.diamond_axe, 1);
/* 266 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 267 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 7:
/* 270 */           is = dropItemRand(Items.diamond_hoe, 1);
/* 271 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 272 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 8:
/* 275 */           is = dropItemRand((Item)Items.diamond_helmet, 1);
/* 276 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 277 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 278 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 279 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 280 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 281 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2)); 
/* 282 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 9:
/* 285 */           is = dropItemRand((Item)Items.diamond_chestplate, 1);
/* 286 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 287 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 288 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 289 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 290 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*     */           break;
/*     */         case 10:
/* 293 */           is = dropItemRand((Item)Items.diamond_leggings, 1);
/* 294 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 295 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 296 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 297 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 298 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*     */           break;
/*     */         case 11:
/* 301 */           is = dropItemRand((Item)Items.diamond_boots, 1);
/* 302 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 303 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
/*     */           
/*     */           break;
/*     */       } 
/*     */     } 
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
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 322 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 327 */     double ks = 0.45D;
/* 328 */     double inair = 1.25D;
/*     */ 
/*     */     
/* 331 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 333 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */ 
/*     */         
/* 336 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 337 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 338 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair * Math.abs(this.worldObj.rand.nextFloat()), Math.sin(f3) * ks);
/*     */       } 
/*     */ 
/*     */       
/* 342 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 346 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 355 */     boolean ret = false;
/* 356 */     if (this.hurt_timer > 0) return false;
/*     */     
/* 358 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 359 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 360 */       this.hurt_timer = 20;
/*     */       
/* 362 */       Entity e = par1DamageSource.getEntity();
/* 363 */       if (e != null && e instanceof EntityLiving) {
/*     */         
/* 365 */         setAttackTarget((EntityLivingBase)e);
/* 366 */         setTarget(e);
/* 367 */         getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*     */       } 
/*     */     } 
/*     */     
/* 371 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 377 */     EntityLivingBase e = null;
/* 378 */     if (this.isDead)
/* 379 */       return;  super.updateAITasks();
/* 380 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/* 381 */     if (this.worldObj.rand.nextInt(4) == 0) {
/* 382 */       e = getAttackTarget();
/* 383 */       if (e != null && !e.isEntityAlive()) {
/* 384 */         setAttackTarget(null);
/* 385 */         e = null;
/*     */       } 
/* 387 */       if (e == null) {
/* 388 */         e = findSomethingToAttack();
/*     */       }
/* 390 */       if (e != null) {
/* 391 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 392 */         if (getDistanceSqToEntity((Entity)e) < ((5.0F + e.width / 2.0F) * (5.0F + e.width / 2.0F))) {
/* 393 */           setAttacking(1);
/*     */           
/* 395 */           if (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(4) == 1) {
/*     */             
/* 397 */             attackEntityAsMob((Entity)e);
/* 398 */             if (!this.worldObj.isRemote) {
/* 399 */               if (this.worldObj.rand.nextInt(3) == 1) {
/* 400 */                 this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_attack", 1.4F, 1.0F);
/*     */               } else {
/* 402 */                 this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_living", 1.0F, 1.0F);
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } else {
/* 407 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/*     */         
/* 411 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */     
/* 415 */     if (this.worldObj.rand.nextInt(150) == 1 && 
/* 416 */       getHealth() < mygetMaxHealth())
/*     */     {
/* 418 */       heal(2.0F);
/*     */     }
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 431 */     if (par1EntityLiving == null)
/*     */     {
/* 433 */       return false;
/*     */     }
/* 435 */     if (par1EntityLiving == this)
/*     */     {
/* 437 */       return false;
/*     */     }
/* 439 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 441 */       return false;
/*     */     }
/*     */     
/* 444 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 446 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 449 */       return false;
/*     */     }
/*     */     
/* 452 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */     {
/* 454 */       return false;
/*     */     }
/* 456 */     if (par1EntityLiving instanceof HerculesBeetle)
/*     */     {
/* 458 */       return false;
/*     */     }
/* 460 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 462 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 463 */       if (p.capabilities.isCreativeMode == true) {
/* 464 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 468 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 473 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 474 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 6.0D, 16.0D));
/* 475 */     Collections.sort(var5, this.TargetSorter);
/* 476 */     Iterator<?> var2 = var5.iterator();
/* 477 */     Entity var3 = null;
/* 478 */     EntityLivingBase var4 = null;
/*     */     
/* 480 */     while (var2.hasNext()) {
/*     */       
/* 482 */       var3 = (Entity)var2.next();
/* 483 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 485 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 487 */         return var4;
/*     */       }
/*     */     } 
/* 490 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 495 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 500 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 511 */     for (k = -3; k < 3; k++) {
/*     */       
/* 513 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 515 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 517 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 518 */           if (bid == Blocks.mob_spawner) {
/* 519 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 520 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 521 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 522 */             if (s != null && 
/* 523 */               s.equals("Hercules Beetle")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 529 */     if (!isValidLightLevel()) return false; 
/* 530 */     if (this.worldObj.isDaytime() == true) return false; 
/* 531 */     if (this.posY < 50.0D) return false;
/*     */ 
/*     */ 
/*     */     
/* 535 */     for (k = -2; k < 2; k++) {
/*     */       
/* 537 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 539 */         for (int i = 2; i < 5; i++) {
/*     */           
/* 541 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 542 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 548 */     HerculesBeetle target = null;
/* 549 */     target = (HerculesBeetle)this.worldObj.findNearestEntityWithinAABB(HerculesBeetle.class, this.boundingBox.expand(16.0D, 6.0D, 16.0D), (Entity)this);
/* 550 */     if (target != null)
/*     */     {
/* 552 */       return false;
/*     */     }
/* 554 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\HerculesBeetle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */